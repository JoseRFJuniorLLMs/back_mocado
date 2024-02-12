package com.loiane.course.dto.mapper;

import com.loiane.course.student.Student;
import com.loiane.course.dto.student.StudentDTO;
import com.loiane.course.dto.student.StudentRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student toModel(StudentRequestDTO studentRequestDTO) {
        Student student = new Student();
        student.setName(studentRequestDTO.getName());
        student.setEmail(studentRequestDTO.getEmail());
        student.setTax_identification_number(studentRequestDTO.getTaxIdentificationNumber());
        student.setPersonal_identification_number(studentRequestDTO.getPersonalIdentificationNumber());
        student.setLogin(studentRequestDTO.getLogin());
        student.setPassword(studentRequestDTO.getPassword());
        // Se houver mais campos para mapear, adicione-os aqui
        return student;
    }

    public StudentDTO toDTO(Student student) {
        if (student == null) {
            return null;
        }
        return new StudentDTO(student.getId(), student.getName(), student.getEmail(), student.getTax_identification_number(), student.getPersonal_identification_number(), student.getLogin(), student.getPassword());
    }
}
