package com.loiane.course.phrase;

import com.loiane.course.PrimeTargetPhraseDTO;
import com.loiane.course.dto.mapper.PrimePhraseMapper;
import com.loiane.course.dto.phrase.PrimeTargetPhrasePageDTO;
import com.loiane.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jakarta.validation.constraints.*;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrimeTargetPhraseService {

    private final PrimeTargetPhraseRepository primeTargetPhraseRepository;
    private final PrimePhraseMapper primePhraseMapper;

    @Autowired
    public PrimeTargetPhraseService(PrimeTargetPhraseRepository primeTargetPhraseRepository, PrimePhraseMapper primePhraseMapper) {
        this.primeTargetPhraseRepository = primeTargetPhraseRepository;
        this.primePhraseMapper = primePhraseMapper;
    }

    public PrimeTargetPhrasePageDTO findAll(@PositiveOrZero int page, @Positive @Max(1000) int pageSize) {
        Page<PrimeTargetPhrase> primeTargetPhrasePage = primeTargetPhraseRepository.findAll(PageRequest.of(page, pageSize));
        List<PrimeTargetPhraseDTO> list = primeTargetPhrasePage.getContent().stream()
                .map(primePhraseMapper::toDTO)
                .toList();
        return new PrimeTargetPhrasePageDTO(list, primeTargetPhrasePage.getTotalElements(), primeTargetPhrasePage.getTotalPages());
    }

    public List<PrimeTargetPhraseDTO> findByPhrase(@NotNull @NotBlank String phrase) {
        List<PrimeTargetPhrase> phrases = primeTargetPhraseRepository.findByPhraseIn(List.of(phrase));
        return phrases.stream()
                .map(primePhraseMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PrimeTargetPhraseDTO findById(@Positive @NotNull Long id) {
        return primeTargetPhraseRepository.findById(id)
                .map(primePhraseMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@Positive @NotNull Long id) {
        PrimeTargetPhrase primeTargetPhrase = primeTargetPhraseRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id));
        primeTargetPhraseRepository.delete(primeTargetPhrase);
    }

}
