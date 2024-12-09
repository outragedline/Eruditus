package com.eruditus.api.dto.season;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.eruditus.api.dto.lesson.LessonDTO;
import com.eruditus.api.model.Course;
import com.eruditus.api.model.Season;

public record SeasonDTO(
		UUID id,
		Short seasonNumber,
		List<LessonDTO> lessons) {
	public SeasonDTO(Season season) {
		this(
				season.getId(),
				season.getSeasonNumber(),
				season.getLessons()
						.stream()
						.map(LessonDTO::new)
						.collect(Collectors.toList()));

	}
}
