package org.example;

public enum RespostaEsperada {
    LISTAR_LIVROS("listar livros"),
    ALUGAR_LIVRO("alugar livro"),
    DEVOLVER_LIVROS("devolver livro"),
    CADASTRAR_LIVRO("cadastrar livro");

    private String descricao;

    RespostaEsperada(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
