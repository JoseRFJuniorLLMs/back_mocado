package com.loiane.course.dto.phrase;

import java.util.List;

public class PrimeTargetPhraseDTO {
    private Long id;
    private String prime;
    private String target;
    private List<String> url;
    private List<String> imagem;
    private List<String> phrase;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrime() {
        return prime;
    }

    public void setPrime(String prime) {
        this.prime = prime;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public List<String> getUrl() {
        return url;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }

    public List<String> getImagem() {
        return imagem;
    }

    public void setImagem(List<String> imagem) {
        this.imagem = imagem;
    }

    public List<String> getPhrase() {
        return phrase;
    }

    public void setPhrase(List<String> phrase) {
        this.phrase = phrase;
    }
}
