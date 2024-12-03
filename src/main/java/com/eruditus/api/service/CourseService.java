
package com.eruditus.api.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eruditus.api.model.Course;
import com.eruditus.api.repository.CourseRepository;

@Service
public class CourseService {
	@Autowired
	private CourseRepository repository;

	public Course getCourseById(UUID id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("Course not found with id: " + id));
	}

	public List<Course> getAllCourses(UUID id) {
		return repository.findAll();
	}
}


    //
    // private final CourseRepository courseRepository;
    //
    // @Transactional
    // public Course createCourse(Course course) {
    //     // Add any pre-creation logic if needed
    //     return courseRepository.save(course);
    // }
    //
    // public List<Course> getAllCourses() {
    //     return courseRepository.findAll();
    // }
    //
    // public Course getCourseById(UUID id) {
    //     return courseRepository.findById(id)
    //         .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + id));
    // }
    //
    // @Transactional
    // public Course updateCourse(UUID id, Course courseDetails) {
    //     Course existingCourse = getCourseById(id);
    //
    //     // Update fields
    //     existingCourse.setTitle(courseDetails.getTitle());
    //     existingCourse.setDescription(courseDetails.getDescription());
    //
    //     return courseRepository.save(existingCourse);
    // }
    //
    // @Transactional
    // public Course partialUpdateCourse(UUID id, Course courseDetails) {
    //     Course existingCourse = getCourseById(id);
    //
    //     // Partial update - only update non-null fields
    //     if (courseDetails.getTitle() != null) {
    //         existingCourse.setTitle(courseDetails.getTitle());
    //     }
    //     if (courseDetails.getDescription() != null) {
    //         existingCourse.setDescription(courseDetails.getDescription());
    //     }
    //
    //     return courseRepository.save(existingCourse);
    // }
    //
    // @Transactional
    // public void deleteCourse(UUID id) {
    //     Course course = getCourseById(id);
    //     courseRepository.delete(course);
    // }
    //
    // public List<Course> searchCourses(int page, int size, String sortBy) {
    //     Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
    //     return courseRepository.findAll(pageable).getContent();
    // }
