#include <stdio.h>
#include <stdlib.h>
#include "lista.h"

int main(int argc, char* argv[]){

    No* n0 = no('J', no('A', NULL));
    No* n1 = no('I', NULL);
    No* n2 = no('R', NULL);
    No* n3 = no('O', NULL);

    int select = atoi(argv[2]);

    lista_inserir_no(n0, n1);
    lista_inserir_no(n0, n2);
    lista_inserir_no(n0, n3);

    lista_imprimir(n0);
    printf("\n");

    // printf("\nSe for um eh por que achou o valor na lista:%d",lista_verificar_existencia(n0, *argv[1]));

    // printf("\nquantidade de elementos:%d", lista_qtd(n0));

    // printf("\nquantidade de ocorrencias :%d", lista_verificar_ocorrencias(n0, *argv[1]));

    // lista_imprimir_inversa(n0);
    
    // lista_inserir_no_i(n0, select, *argv[1]);

    // lista_remover_no_i(n0, select);

    lista_remover_no(n0, *argv[1]);
    lista_imprimir(n0);

    return 0;
}