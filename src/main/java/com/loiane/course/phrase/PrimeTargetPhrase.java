package com.loiane.course.phrase;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.Objects;

@Entity
public class PrimeTargetPhrase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prime;
    private String target;
    private ArrayList<String> url = new ArrayList<>();
    private ArrayList<String> imagem = new ArrayList<>();
    private ArrayList<String> phrase = new ArrayList<>();

    public PrimeTargetPhrase(String prime, String target, ArrayList<String> url, ArrayList<String> imagem, ArrayList<String> phrase) {
        this.prime = prime;
        this.target = target;
        this.url = url;
        this.imagem = imagem;
        this.phrase = phrase;
    }

    public PrimeTargetPhrase() {
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
        return url;
    }

    public void setUrl(ArrayList<String> url) {
        this.url = url;
    }

    public ArrayList<String> getImagem() {
        return imagem;
    }

    public void setImagem(ArrayList<String> imagem) {
        this.imagem = imagem;
    }

    public ArrayList<String> getPhrase() {
        return phrase;
    }

    public void setPhrase(ArrayList<String> phrase) {
        this.phrase = phrase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrimeTargetPhrase that = (PrimeTargetPhrase) o;
        return Objects.equals(id, that.id) && Objects.equals(prime, that.prime) && Objects.equals(target, that.target) && Objects.equals(url, that.url) && Objects.equals(imagem, that.imagem) && Objects.equals(phrase, that.phrase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prime, target, url, imagem, phrase);
    }
}
