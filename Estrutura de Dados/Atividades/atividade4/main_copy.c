#include <stdio.h>
#include <stdlib.h>
#include "bubble_sort.h"

void imprimir_arr(int *arr, int n) {
    for (int i = 0; i < n; i++) {
       
        if(i == n-1){
            printf("%d", arr[i]);
        }else{
            printf("%d,", arr[i]);
        }
    }
    printf("\n");
}



void fileAtt(int *arr, int n){
    FILE* file;
    file = fopen("ArrayOrdenado.txt", "wt");
    

    if (file == NULL) {
        perror("Error opening file");
        return ;
    }

    for (int i = 0; i < n; i++) {
        if(i == n-1){
            fprintf(file, "%d", arr[i]);
        }else{
            fprintf(file, "%d, ", arr[i]); 
        }
    }

    fclose(file);

     printf("Dentro do arquivo Ordenado: ");
    imprimir_arr(arr, n);

}


///Users/jairojunior/Documents/GitHub/Materias/Estrutura de Dados/Atividades/atividade5/arquivoDeLeitura.txt
int main(int argc, char* argv[]) {
    FILE* file;
    file = fopen("/Users/jairojunior/Documents/GitHub/Materias/Estrutura de Dados/Atividades/atividade5/arquivoDeLeitura.txt", "r");

    if (file == NULL) {
        perror("Error opening file");
        return 1;
    }

    int arr[100];
    int j = 0;

    while (fscanf(file, "%i,", &arr[j]) != EOF) {
        j++;
    }

    int  n = j; 

    fclose(file);

    printf("Dentro do arquivo de Leitura: ");
    imprimir_arr(arr, n);
    bubble_sort(arr, n);

    fileAtt(arr, n);

   

    return 0;
}

