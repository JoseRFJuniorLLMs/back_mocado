package com.loiane.course.student;

import com.loiane.course.enums.Status;
import com.loiane.course.enums.converters.StatusConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.validator.constraints.Length;

import java.util.Objects;

@SQLDelete(sql = "UPDATE Estudent SET status = 'Inactive' WHERE id=?")
@SQLRestriction("status <> 'Inactive'")
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    @Length(min = 5, max = 200)
    @Column(length = 200, nullable = false)
    private String name;

    @NotNull
    private String email;
    @NotNull
    private String tax_identification_number;
    @NotNull
    private String personal_identification_number;
    @NotNull
    private String login;
    @NotNull
    private String password;

    @NotNull
    @Column(length = 8, nullable = false)
    @Convert(converter = StatusConverter.class)
    private Status status = Status.ACTIVE;

    public Student(Long id, String name, String email, String tax_identification_number, String personal_identification_number, String login, String password, Status status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.tax_identification_number = tax_identification_number;
        this.personal_identification_number = personal_identification_number;
        this.login = login;
        this.password = password;
        this.status = status;
    }

    public Student() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTax_identification_number() {
        return tax_identification_number;
    }

    public void setTax_identification_number(String tax_identification_number) {
        this.tax_identification_number = tax_identification_number;
    }

    public String getPersonal_identification_number() {
        return personal_identification_number;
    }

    public void setPersonal_identification_number(String personal_identification_number) {
        this.personal_identification_number = personal_identification_number;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(email, student.email) && Objects.equals(tax_identification_number, student.tax_identification_number) && Objects.equals(personal_identification_number, student.personal_identification_number) && Objects.equals(login, student.login) && Objects.equals(password, student.password) && status == student.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, tax_identification_number, personal_identification_number, login, password, status);
    }

}
