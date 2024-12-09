package com.eruditus.api.dto.lesson;

import java.util.UUID;

import com.eruditus.api.model.Lesson;

import jakarta.validation.constraints.NotBlank;

public record LessonDTO(
		UUID id,
		String title,
		String description,
		String videoUrl) {

	public LessonDTO(Lesson lesson) {
		this(
				lesson.getId(),
				lesson.getTitle(),
				lesson.getDescription(),
				lesson.getVideoUrl());
	}
}
