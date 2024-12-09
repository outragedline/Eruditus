
package com.eruditus.api.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eruditus.api.model.Course;
import com.eruditus.api.repository.CourseRepository;

import jakarta.transaction.Transactional;

@Service
public class CourseService {
	@Autowired
	private CourseRepository repository;

	@Transactional
	public Course createCourse(Course course) {
		return repository.save(course);
	}

	public Course findById(UUID id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("Course not found with id: " + id));
	}

	public List<Course> getAllCourses() {
		return repository.findAll();
	}

	public void deleteCourse(UUID id) {
		Course course = repository.findById(id).orElseThrow(() -> new RuntimeException());
		repository.delete(course);
		return;
	}

	public Course updateCourse(UUID id, Course newCourse) {
		// Yeah its different because im tired and dont care anymore i just want to
		// finish this project my god
		// the deadline is tomorrow
		Course course = repository.findById(id).orElse(null);
		course.setTitle(newCourse.getTitle());
		course.setCategory(newCourse.getCategory());
		course.setDescription(newCourse.getDescription());

		return repository.save(newCourse);
	}
}
