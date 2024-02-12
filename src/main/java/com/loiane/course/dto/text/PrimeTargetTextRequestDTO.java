package com.loiane.course.dto.text;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PrimeTargetTextRequestDTO {
    @NotBlank
    @NotNull
    private String prime;

    @NotBlank
    @NotNull
    private String target;

    @NotBlank
    @NotNull
    private String text;

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
}
