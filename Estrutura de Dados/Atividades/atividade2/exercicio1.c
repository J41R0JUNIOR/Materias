#include <stdio.h>

int main (void){

    int array[] =  {1,2,3};
    int soma = 0;

    for(int i = 0; i < (sizeof(array)/sizeof(int)); ++i){
        soma += array[i];
    }

    printf("%i",soma);

    return 0;
}