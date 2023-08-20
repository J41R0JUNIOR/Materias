#include <stdio.h>
#include <string.h>


int main(void){

    char array[][50] = {"Carro", "Apollo11", "Flamengo"};
    char stringBusca[50] = {"Apollo11"};
    int compararString(char buscar[50], char array[][50]);

    
    if(compararString(stringBusca, array)){
        printf("Existe uma String igual dentro do vetor");
    }else{
        printf("Nao existe nenhuma String dentro do vetor");
    }

    



    return 0;
}

int compararString(char buscar[50], char array[][50]){

    int result = 1;

    for(int i = 0; i < 3 ; ++i){
        result = strcmp(buscar, array[i]);


        if (result == 0){
            return 1;
        }
    }
    return 0;
}