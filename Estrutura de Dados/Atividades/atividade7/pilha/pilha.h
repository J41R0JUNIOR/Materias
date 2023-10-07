#ifndef PILHA_H
#define PILHA_H

typedef struct {
    char nome[50];
    int prioridade;
} Paciente;

typedef struct Node {
    Paciente paciente;
    struct Node* next;
} Node;

typedef struct {
    Node* top;
} Pilha;

Pilha* criarPilha();
void push(Pilha* pilha, Paciente paciente);
Paciente pop(Pilha* pilha);
Pilha* criarPilhaPrioridade();

#endif
