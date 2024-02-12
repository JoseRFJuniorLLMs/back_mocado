package com.loiane.course.text;

import com.loiane.course.dto.text.PrimeTargetTextDTO;
import com.loiane.course.dto.text.PrimeTargetTextPageDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/text")
@Validated
public class PrimeTargetTextController {

    private final PrimeTargetTextService primeTargetTextService;

    public PrimeTargetTextController(PrimeTargetTextService primeTargetTextService) {
        this.primeTargetTextService = primeTargetTextService;
    }

    @GetMapping
    public PrimeTargetTextPageDTO findAll(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "10") int pageSize) {
        return primeTargetTextService.findAll(page, pageSize);
    }

    @GetMapping("/searchByPrime")
    public List<PrimeTargetTextDTO> findByPrime(@RequestParam @NotNull @NotBlank String prime) {
        return primeTargetTextService.findByPrime(prime);
    }

    @GetMapping("/{id}")
    public PrimeTargetTextDTO findById(@PathVariable @Positive @NotNull Long id) {
        return primeTargetTextService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @Positive @NotNull Long id) {
        primeTargetTextService.delete(id);
    }
}
