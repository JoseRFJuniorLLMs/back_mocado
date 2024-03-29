package com.loiane.course.dto.student;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Used as response object that represents a Course
 */
public record StudentDTO(
        @JsonProperty("_id") Long id,
        String name, String email,
        String taxIdentificationNumber,
        String personalIdentificationNumber,
        String login,
        String password) {
}
