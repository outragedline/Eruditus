package com.eruditus.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eruditus.api.model.Lesson;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, UUID> {
}
