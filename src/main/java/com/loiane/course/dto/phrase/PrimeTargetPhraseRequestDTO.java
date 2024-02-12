package com.loiane.course.dto.phrase;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class PrimeTargetPhraseRequestDTO {
    @NotBlank @NotNull @Length(min = 5, max = 200) private String prime;
    @NotBlank @NotNull @Length(min = 5, max = 200) private String target;
    // Se necessário, adicione validações para os campos url, imagem e phrase aqui

    // Getters e setters
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
}
