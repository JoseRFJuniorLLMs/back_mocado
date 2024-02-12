package com.loiane.course.dto.phrase;

import java.util.List;

/**
 * Representa um objeto de resposta que representa uma página com uma lista de PrimeTargetPhaseDTO.
 */
public record PrimeTargetPhrasePageDTO(List<com.loiane.course.PrimeTargetPhraseDTO> primeTargetPhases, long totalElements, int totalPages) {

}
