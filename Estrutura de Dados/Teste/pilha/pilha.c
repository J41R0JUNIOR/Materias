#include <stdio.h>
#include <stdlib.h>
#include "pilha.h"


Pilha* pilha(){
    Pilha *P = (Pilha*)malloc(sizeof(Pilha));
    P->topo = NULL;
    P->quantidade_objetos = 0;
    return P;
}

void empilhar(Objeto* o, Pilha *P){
    o->proximo_objeto = P->topo;
    P->topo = o;
    P->quantidade_objetos ++;
}

Objeto* desempilhar(Pilha* P){
    if(P->quantidade_objetos == 0){
        return NULL;
    }
    Objeto* o = P->topo;
    P->topo = o->proximo_objeto;
    P->quantidade_objetos--;
    return o;
}
