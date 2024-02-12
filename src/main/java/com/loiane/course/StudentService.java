package com.loiane.course;

import com.loiane.course.dto.StudentDTO;
import com.loiane.course.dto.StudentPageDTO;
import com.loiane.course.dto.mapper.StudentMapper;
import com.loiane.exception.RecordNotFoundException;

import jakarta.validation.constraints.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentPageDTO findAll(@PositiveOrZero int page, @Positive @Max(1000) int pageSize) {
        Page<Student> studentPage = studentRepository.findAll(PageRequest.of(page, pageSize));
        List<StudentDTO> list = studentPage.getContent().stream()
                .map(studentMapper::toDTO)
                .toList();
        return new StudentPageDTO(list, studentPage.getTotalElements(), studentPage.getTotalPages());
    }

    public List<StudentDTO> findByName(@NotNull @NotBlank String name) {
        return studentRepository.findByName(name).stream()
                .map(studentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public StudentDTO findById(@Positive @NotNull Long id) {
        return studentRepository.findById(id)
                .map(studentMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }


    public void delete(@Positive @NotNull Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id));
        studentRepository.delete(student);
    }
}
