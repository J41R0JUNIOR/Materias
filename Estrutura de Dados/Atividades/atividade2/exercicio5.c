#include <stdio.h>
#include <stdlib.h>

int* multiplica_array(const int* array1, const int* array2, int tamanho) {
    int* resultado = (int*)malloc(tamanho * sizeof(int));
    
    if (resultado == NULL) {
        printf("Erro na alocação de memória.\n");
        return NULL;
    }

    for (int i = 0; i < tamanho; i++) {
        resultado[i] = array1[i] * array2[i];
    }

    return resultado;
}

int main() {
    int array1[] = {5, 7, 9, 6};
    int array2[] = {5, 7, 9, 6};
    int tamanho = sizeof(array1) / sizeof(array1[0]);

    int* resultado = multiplica_array(array1, array2, tamanho);

    if (resultado != NULL) {
        printf("Saída: [");
        for (int i = 0; i < tamanho; i++) {
            printf("%d", resultado[i]);
            if (i < tamanho - 1) {
                printf(", ");
            }
        }
        printf("]\n");

        free(resultado); 
    }

    return 0;
}
