package com.loiane.course.course;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.loiane.course.dto.course.CourseDTO;
import com.loiane.course.dto.course.CoursePageDTO;
import com.loiane.course.dto.course.CourseRequestDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * Represents the REST API for the Course resource.
 */
@CrossOrigin(origins = "*")
@Validated
@RestController
@RequestMapping("api/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public CoursePageDTO findAll(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize) {
        return courseService.findAll(page, pageSize);
    }

    @GetMapping("/searchByName")
    public List<CourseDTO> findByName(@RequestParam @NotNull @NotBlank String name) {
        return courseService.findByName(name);
    }

    @GetMapping("/{id}")
    public CourseDTO findById(@PathVariable @Positive @NotNull Long id) {
        return courseService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CourseDTO create(@RequestBody @Valid CourseRequestDTO course) {
        return courseService.create(course);
    }

    @PutMapping(value = "/{id}")
    public CourseDTO update(@PathVariable @Positive @NotNull Long id,
            @RequestBody @Valid CourseRequestDTO course) {
        return courseService.update(id, course);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @Positive @NotNull Long id) {
        courseService.delete(id);
    }
}
