package com.loiane.course.text;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrimeTargetTextRepository extends JpaRepository<PrimeTargetText, Long> {

    Page<PrimeTargetText> findByPrime(Pageable pageable, String prime);

    List<PrimeTargetText> findByPrime(String prime);
}
