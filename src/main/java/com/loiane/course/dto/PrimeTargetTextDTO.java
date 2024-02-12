package com.loiane.course.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PrimeTargetTextDTO(
        @JsonProperty("_id") int id,
        String prime,
        String target,
        String text
) {
    @Override
    public int id() {
        return id;
    }

    public String getPrime() {
        return prime;
    }

    public String getTarget() {
        return target;
    }

    public String getText() {
        return text;
    }
}
