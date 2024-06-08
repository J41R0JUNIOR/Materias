package org.example;

public class Book {
    private String titulo;
    private String autor;
    private String genero;
    private int exemplares;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getExemplares() {
        return exemplares;
    }

    public void setExemplares(int exemplares) {
        this.exemplares = exemplares;
    }
// Getters e Setters

    @Override
    public String toString() {
        return "Title: " + titulo + ", Author: " + autor + ", Genre: " + genero + ", Copies: " + exemplares;
    }
}