#include <stdio.h>
#include <stdlib.h>
#include "lista.h"
#include <time.h>

int main(int argc, char* argv[]){

    // No* n0 = no(007.0, no(0.54, NULL));
    // No* n1 = no(3.14, NULL);
    // No* n2 = no(7.07, NULL);
    // No* n3 = no(08.032, NULL);

    int select = atoi(argv[2]);

    // lista_inserir_no(n0, n1);
    // lista_inserir_no(n0, n2);
    // lista_inserir_no(n0, n3);

    // lista_imprimir(n0);
    // printf("\n");


    // printf("\nSe for um eh por que achou o valor na lista:%d",lista_verificar_existencia(n0, *argv[1]));

    // printf("\nquantidade de elementos:%d", lista_qtd(n0));

    // printf("\nquantidade de ocorrencias :%d", lista_verificar_ocorrencias(n0, *argv[1]));

    // lista_imprimir_inversa(n0);
    
    // lista_inserir_no_i(n0, select, *argv[1]);

    // lista_remover_no_i(n0, select);

    // lista_remover_no(n0, *argv[1]);
    // lista_imprimir(n0);



/////////////////////////////////////ainda nao separei/////////////////////////////////////////////////////

    printf("\n-----------------------lista a partir do arquivo-----------------------\n");
    FILE* file;
    No *headOrdenado, *headDesordenado, *tailDesordenado;
    clock_t start_time, end_time;
    double elapsed_time;

    file = fopen(argv[3], "r");

    if (file == NULL) {
        perror("Error opening file");
        return 1;
    }
    
    float value = 0.0;
    int i = 0;

    start_time = clock();
    while (fscanf(file, "%f", &value) != EOF) {
        if (i == 0){
            headOrdenado = no(value, NULL);
            // headDesordenado = no(value, NULL);
            // tailDesordenado = headDesordenado;
            i++;
        }else{
            lista_inserir_no_ordenado(headOrdenado, no(value, NULL));
            // lista_inserir_no(headDesordenado, tailDesordenado, value); 
            // tailDesordenado->proximo_no = no(value, NULL); 
            // tailDesordenado = tailDesordenado->proximo_no;
      
        }
        printf("%f\n", value);
    }
    printf("------------=--===-=-=-=-=-=---------==========--------========------=======-----=");
    end_time = clock();


    elapsed_time = (double)(end_time - start_time) / CLOCKS_PER_SEC;
    printf("=====================================---------------------===================================\n");
    printf("\nTempo de inserção: %f segundos\n", elapsed_time);
    printf("Terminou tudo\n");

    return 0;
}