#include <stdio.h>
#include <stdlib.h>

int main (int argc, char* argv[]){

    int array[] = {1,4,3,6,4,7,45,3,5,3,35,4,7,7,46,465};
    int pesquisa = 0;
    int qtdApareceu(int array[], int pesquisa, int tamArray);

    pesquisa = atoi(argv[1]); 
    int tamArray = (sizeof(array)/sizeof(int));

    printf("Quantidades que o %i apareceu foi = %i", pesquisa, qtdApareceu(array, pesquisa, tamArray));

    return 0;
}

int qtdApareceu(int array[], int pesquisa, int tamArray){
    int qtd = 0;


    for(int i = 0; i < tamArray; ++i){
        if(pesquisa == array[i]){
            qtd++;
        }
    }
    return qtd;
}