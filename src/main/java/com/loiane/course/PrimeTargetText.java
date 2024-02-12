package com.loiane.course;

import com.loiane.course.enums.Status;
import com.loiane.course.enums.converters.StatusConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;


@Entity
public class PrimeTargetText {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String prime;
    private String target;
    private String text;
    @NotNull
    @Column(length = 8, nullable = false)
    @Convert(converter = StatusConverter.class)
    private Status status = Status.ACTIVE;

    public PrimeTargetText(int id, String prime, String target, String text, Status status) {
        this.id = id;
        this.prime = prime;
        this.target = target;
        this.text = text;
        this.status = status;
    }

    public PrimeTargetText() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrime() {
        return prime;
    }

    public void setPrime(String prime) {
        this.prime = prime;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
        PrimeTargetText that = (PrimeTargetText) o;
        return id == that.id && Objects.equals(prime, that.prime) && Objects.equals(target, that.target) && Objects.equals(text, that.text) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prime, target, text, status);
    }
}
