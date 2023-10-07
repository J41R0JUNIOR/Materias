#include "fila.h"
#include <stdio.h>

void inicializarFila(Fila *f) {
    f->frente = -1;
    f->tras = -1;
}

int filaVazia(Fila *f) {
    return f->frente == -1;
}

int filaCheia(Fila *f) {
    return (f->tras + 1) % MAX_PEDIDOS == f->frente;
}

void enfileirar(Fila *f, int numeroPedido) {
    if (!filaCheia(f)) {
        if (filaVazia(f)) {
            f->frente = 0;
        }
        f->tras = (f->tras + 1) % MAX_PEDIDOS;
        f->pedidos[f->tras] = numeroPedido;
    } else {
        printf("A fila de pedidos esta cheia. Nao e possível adicionar mais pedidos.\n");
    }
}

int desenfileirar(Fila *f) {
    if (!filaVazia(f)) {
        int numeroPedido = f->pedidos[f->frente];
        if (f->frente == f->tras) {
            inicializarFila(f);
        } else {
            f->frente = (f->frente + 1) % MAX_PEDIDOS;
        }
        return numeroPedido;
    }
    printf("A fila de pedidos esta vazia. Nao e possível remover um pedido.\n");
    return -1; 
}
