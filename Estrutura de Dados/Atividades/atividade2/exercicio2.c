#include <stdio.h>

int main (void){

    int vetor[] = {2,43,5,45,32,75,5435,3,-3308};
    int maior, menor;

    maior = vetor[0];
    menor = vetor[0];


    for(int i = 0; i < (sizeof(vetor)/sizeof(int)); ++i){
        if(vetor[i] > maior){
            maior = vetor[i];
        }else if(vetor[i] < menor){
            menor = vetor[i];
        }
    }

    printf("Maior = %i, Menor = %i", maior, menor);
}