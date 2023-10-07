#ifndef FILA_H
#define FILA_H

#define MAX_PEDIDOS 50

typedef struct {
    int pedidos[MAX_PEDIDOS];
    int frente, tras;
} Fila;

void inicializarFila(Fila *f);
int filaVazia(Fila *f);
int filaCheia(Fila *f);
void enfileirar(Fila *f, int numeroPedido);
int desenfileirar(Fila *f);

#endif
