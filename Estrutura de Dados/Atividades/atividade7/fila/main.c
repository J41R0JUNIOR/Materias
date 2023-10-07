#include <stdio.h>
#include "fila.h"

int main() {
    Fila pedidosFila;
    inicializarFila(&pedidosFila);

    enfileirar(&pedidosFila, 1);
    enfileirar(&pedidosFila, 2);
    enfileirar(&pedidosFila, 3);

    printf("Pedido %d em preparo.\n", desenfileirar(&pedidosFila));
    printf("Pedido %d em preparo.\n", desenfileirar(&pedidosFila));

    enfileirar(&pedidosFila, 4);
    enfileirar(&pedidosFila, 5);

    printf("Pedido %d em preparo.\n", desenfileirar(&pedidosFila));
    printf("Pedido %d em preparo.\n", desenfileirar(&pedidosFila));

    return 0;
}
