package com.loiane.course.dto.mapper;

import com.loiane.course.text.PrimeTargetText;
import com.loiane.course.dto.text.PrimeTargetTextDTO;
import org.springframework.stereotype.Component;

@Component
public class PrimeTextMapper {

    public PrimeTargetText toModel(PrimeTargetTextDTO primeTargetTextDTO) {
        PrimeTargetText primeTargetText = new PrimeTargetText();
        primeTargetText.setPrime(primeTargetTextDTO.getPrime());
        primeTargetText.setTarget(primeTargetTextDTO.getTarget());
        primeTargetText.setText(primeTargetTextDTO.getText());
        // Se houver mais campos para mapear, adicione-os aqui
        return primeTargetText;
    }

    public PrimeTargetTextDTO toDTO(PrimeTargetText primeTargetText) {
        if (primeTargetText == null) {
            return null;
        }
        return new PrimeTargetTextDTO(primeTargetText.getId(), primeTargetText.getPrime(), primeTargetText.getTarget(), primeTargetText.getText());
    }
}
