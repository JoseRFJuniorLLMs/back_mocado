package com.loiane.course;

import com.loiane.course.dto.PrimeTargetTextDTO;
import com.loiane.course.dto.PrimeTargetTextPageDTO;
import com.loiane.course.dto.mapper.PrimeTextMapper;
import com.loiane.exception.RecordNotFoundException;

import jakarta.validation.constraints.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrimeTargetTextService {

    private final PrimeTargetTextRepository primeTargetTextRepository;
    private final PrimeTextMapper primeTextMapper;

    public PrimeTargetTextService(PrimeTargetTextRepository primeTargetTextRepository, PrimeTextMapper primeTextMapper) {
        this.primeTargetTextRepository = primeTargetTextRepository;
        this.primeTextMapper = primeTextMapper;
    }

    public PrimeTargetTextPageDTO findAll(@PositiveOrZero int page, @Positive @Max(1000) int pageSize) {
        Page<PrimeTargetText> primeTargetTextPage = primeTargetTextRepository.findAll(PageRequest.of(page, pageSize));
        List<PrimeTargetTextDTO> list = primeTargetTextPage.getContent().stream()
                .map(primeTextMapper::toDTO)
                .toList();
        return new PrimeTargetTextPageDTO(list, primeTargetTextPage.getTotalElements(), primeTargetTextPage.getTotalPages());
    }

    public List<PrimeTargetTextDTO> findByPrime(@NotNull @NotBlank String prime) {
        return primeTargetTextRepository.findByPrime(prime).stream()
                .map(primeTextMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PrimeTargetTextDTO findById(@Positive @NotNull Long id) {
        return primeTargetTextRepository.findById(id)
                .map(primeTextMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }


    public void delete(@Positive @NotNull Long id) {
        PrimeTargetText primeTargetText = primeTargetTextRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id));
        primeTargetTextRepository.delete(primeTargetText);
    }
}
