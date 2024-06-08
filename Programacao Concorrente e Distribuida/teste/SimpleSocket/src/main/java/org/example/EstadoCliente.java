package org.example;

public enum EstadoCliente {
    NORMAL("normal"),
    ALUGANDO_LIVRO("alugando livro"),
    DEVOLVENDO_LIVRO("devolvendo livro"),
    CADASTRANDO_LIVRO("cadastrando livro");

    private String descricao;

    EstadoCliente(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
