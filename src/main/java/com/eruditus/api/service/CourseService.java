
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

	public Course getCourseById(UUID id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("Course not found with id: " + id));
	}

	public List<Course> getAllCourses(UUID id) {
		return repository.findAll();
	}
}
