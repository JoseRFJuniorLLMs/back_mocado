package com.loiane.course.phrase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrimeTargetPhraseRepository extends JpaRepository<PrimeTargetPhrase, Long> {
    // Método personalizado para encontrar frases por uma determinada string
    List<PrimeTargetPhrase> findByPhraseIn(List<String> phrases);
}
