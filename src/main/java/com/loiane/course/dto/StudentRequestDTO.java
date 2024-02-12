package com.loiane.course.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class StudentRequestDTO {
    @NotBlank @NotNull @Length(min = 5, max = 200) String name;
}
