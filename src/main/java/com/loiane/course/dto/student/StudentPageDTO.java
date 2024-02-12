package com.loiane.course.dto.student;

import java.util.List;

/**
 * Used as response object that represents a Page with a list of Students.
 */
public record StudentPageDTO(List<StudentDTO> students, long totalElements, int totalPages) {

}
