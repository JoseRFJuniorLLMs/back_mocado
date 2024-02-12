package com.loiane.course.phrase;

import com.loiane.course.PrimeTargetPhraseDTO;
import com.loiane.course.dto.phrase.PrimeTargetPhrasePageDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/phrase")
@Validated
public class PrimeTargetPhraseController {

    private final PrimeTargetPhraseService primeTargetPhraseService;

    public PrimeTargetPhraseController(PrimeTargetPhraseService primeTargetPhraseService) {
        this.primeTargetPhraseService = primeTargetPhraseService;
    }

    @GetMapping
    public PrimeTargetPhrasePageDTO findAll(@RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "10") int pageSize) {
        return primeTargetPhraseService.findAll(page, pageSize);
    }

    @GetMapping("/searchByPhrase")
    public List<com.loiane.course.PrimeTargetPhraseDTO> findByPhrase(@RequestParam @NotNull @NotBlank String phrase) {
        return primeTargetPhraseService.findByPhrase(phrase);
    }

    @GetMapping("/{id}")
    public PrimeTargetPhraseDTO findById(@PathVariable @Positive @NotNull Long id) {
        return primeTargetPhraseService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @Positive @NotNull Long id) {
        primeTargetPhraseService.delete(id);
    }
}
