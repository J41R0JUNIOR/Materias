package org.example;

public class Livro {
    private String titulo;
    private String autor;
    private String genero;
    private int exemplares;

    // Getters e Setters

    @Override
    public String toString() {
        return "Titulo: " + titulo + ", Autor: " + autor + ", Genero: " + genero + ", Exemplares: " + exemplares;
    }
}