package com.loiane.course.dto.mapper;

import com.loiane.course.phrase.PrimeTargetPhrase;
import com.loiane.course.PrimeTargetPhraseDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PrimePhraseMapper {

    public PrimeTargetPhrase toModel(PrimeTargetPhraseDTO requestDTO) {
        PrimeTargetPhrase primeTargetPhrase = new PrimeTargetPhrase();
        primeTargetPhrase.setPrime(requestDTO.getPrime());
        primeTargetPhrase.setTarget(requestDTO.getTarget());
        primeTargetPhrase.setUrl(new ArrayList<>(requestDTO.getUrl()));
        primeTargetPhrase.setImagem(new ArrayList<>(requestDTO.getImagem()));
        primeTargetPhrase.setPhrase(new ArrayList<>(requestDTO.getPhrase()));
        // Se houver mais campos para mapear, adicione-os aqui
        return primeTargetPhrase;
    }

    public PrimeTargetPhraseDTO toDTO(PrimeTargetPhrase primeTargetPhrase) {
        if (primeTargetPhrase == null) {
            return null;
        }
        return new PrimeTargetPhraseDTO(primeTargetPhrase.getId(), primeTargetPhrase.getPrime(), primeTargetPhrase.getTarget(), primeTargetPhrase.getUrl(), primeTargetPhrase.getImagem(), primeTargetPhrase.getPhrase());
    }
}
