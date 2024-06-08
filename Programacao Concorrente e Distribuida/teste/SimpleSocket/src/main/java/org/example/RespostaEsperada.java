package org.example;

public enum RespostaEsperada {
    LISTAR_LIVROS("1"),
    ALUGAR_LIVRO("2"),
    DEVOLVER_LIVRO("3"),
    CADASTRAR_LIVRO("cadastrar livro");

    private String descricao;

    RespostaEsperada(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
