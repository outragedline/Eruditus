package com.eruditus.api.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.eruditus.api.dto.course.CourseCreationDTO;
import com.eruditus.api.dto.course.CourseDTO;
import com.eruditus.api.model.Course;
import com.eruditus.api.model.User;
import com.eruditus.api.repository.UserRepository;
import com.eruditus.api.service.AuthService;
import com.eruditus.api.service.CourseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("courses")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@Autowired
	AuthService authService;

	@PostMapping
	ResponseEntity<?> createCourse(@Valid @RequestBody CourseCreationDTO data) {
		Course createdCourse;
		try {
			Course course = new Course();
			course.setTitle(data.title());
			course.setDescription(data.description());
			course.setCategory(data.category());
			createdCourse = courseService.createCourse(course);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(e.getStackTrace().toString());
		}
		return ResponseEntity.created(
				ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(createdCourse.getId())
						.toUri())
				.body(new CourseDTO(createdCourse));
	}

	@GetMapping("/{id}")
	ResponseEntity<CourseDTO> courseDetails(@PathVariable UUID id) {
		Course course;
		try {
			course = courseService.getCourseById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(new CourseDTO(course));
	}

	@DeleteMapping("/{id}")
	ResponseEntity<?> deleteCourse(@PathVariable UUID id) {
		try {
			courseService.deleteCourse(id);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
