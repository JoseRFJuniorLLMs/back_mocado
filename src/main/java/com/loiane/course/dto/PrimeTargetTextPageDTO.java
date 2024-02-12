package com.loiane.course.dto;

import java.util.List;

public record PrimeTargetTextPageDTO(List<PrimeTargetTextDTO> primeTargetTexts, long totalElements, int totalPages) {

}

