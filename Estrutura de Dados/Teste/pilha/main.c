#include <stdio.h>
#include <stdlib.h>
#include "pilha.h"

int main (void){

    Objeto o1;
    o1.valor = 'A';
    Objeto o2;
    o2.valor = 'B';

 
   

    Pilha* P = pilha();

    empilhar(&o1, P);
    empilhar(&o2, P);

    Objeto* o;

    do{
        o = desempilhar(P);
        if(o != NULL){
            printf("\n%c", o->valor);
        }
    }while(o != NULL);


    return 0;
}