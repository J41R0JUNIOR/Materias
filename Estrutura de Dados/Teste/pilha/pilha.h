#include <stdio.h>
#include <stdlib.h>

typedef struct Objeto{
    char valor;
    struct Objeto* proximo_objeto;

}Objeto;

typedef struct Pilha{
    Objeto* topo;
    int quantidade_objetos;
}Pilha;

Pilha* pilha();

void empilhar(Objeto* o, Pilha *P);
Objeto* desempilhar(Pilha* P);
