package com.loiane.course;

import com.loiane.course.dto.*;

import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/student")
@Validated
public class StudentController {
/*
    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public CoursePageDTO findAll(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "10") int pageSize) {
        return studentService.findAll(page, pageSize);
    }

    @GetMapping("/searchByName")
    public List<StudentDTO> findByName(@RequestParam @NotNull @NotBlank String name) {
        return studentService.findByName(name);
    }

    @GetMapping("/{id}")
    public StudentDTO findById(@PathVariable @Positive @NotNull Long id) {
        return studentService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public StudentDTO create(@RequestBody @Valid CourseRequestDTO course) {
        return studentService.create(course);
    }

    @PutMapping(value = "/{id}")
    public StudentDTO update(@PathVariable @Positive @NotNull Long id,
                            @RequestBody @Valid CourseRequestDTO course) {
        return studentService.update(id, course);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @Positive @NotNull Long id) {
        studentService.delete(id);
    }*/
}