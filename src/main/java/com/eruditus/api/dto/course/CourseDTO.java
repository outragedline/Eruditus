package com.eruditus.api.dto.course;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.eruditus.api.model.Course;

public record CourseDTO(UUID id,
		String title,
		String description,
		String category,
		List<SeasonDTO> seasons) {
	public CourseDTO(Course course) {
		this(
				course.getId(),
				course.getTitle(),
				course.getDescription(),
				course.getCategory(),
				course.getSeasons()
						.stream()
						.map(SeasonDTO::new)
						.collect(Collectors.toList()));
	}
}
