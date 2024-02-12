package com.loiane.course;

import java.util.ArrayList;
import java.util.List;

public class PrimeTargetPhraseDTO {
    private Long id;
    private String prime;
    private String target;
    private List<String> url;
    private List<String> imagem;
    private List<String> phrase;

    public PrimeTargetPhraseDTO(Long id, String prime, String target, List<String> url, List<String> imagem, List<String> phrase) {
        this.id = id;
        this.prime = prime;
        this.target = target;
        this.url = url;
        this.imagem = imagem;
        this.phrase = phrase;
    }

    public PrimeTargetPhraseDTO() {
    }

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

    public ArrayList<String> getUrl() {
        return (ArrayList<String>) url;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }

    public ArrayList<String> getImagem() {
        return (ArrayList<String>) imagem;
    }

    public void setImagem(List<String> imagem) {
        this.imagem = imagem;
    }

    public ArrayList<String> getPhrase() {
        return (ArrayList<String>) phrase;
    }

    public void setPhrase(List<String> phrase) {
        this.phrase = phrase;
    }
}
