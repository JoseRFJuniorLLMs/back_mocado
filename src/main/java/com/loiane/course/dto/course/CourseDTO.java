package com.loiane.course.dto.course;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.loiane.course.dto.LessonDTO;

/**
 * Used as response object that represents a Course
 */
public record CourseDTO(
        @JsonProperty("_id") Long id,
        String name, String category, List<LessonDTO> lessons) {
}
