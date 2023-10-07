#include <stdio.h>
#include <stdlib.h>
#include "pilha.h"

Pilha* criarPilha() {
    Pilha* pilha = (Pilha*)malloc(sizeof(Pilha));
    pilha->top = NULL;
    return pilha;
}

void push(Pilha* pilha, Paciente paciente) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->paciente = paciente;
    newNode->next = pilha->top;
    pilha->top = newNode;
}

Paciente pop(Pilha* pilha) {
    if (pilha->top == NULL) {
        Paciente pacienteVazio = {"", 0};
        return pacienteVazio;
    }
    Node* temp = pilha->top;
    Paciente paciente = temp->paciente;
    pilha->top = pilha->top->next;
    free(temp);
    return paciente;
}

Pilha* criarPilhaPrioridade() {
    return criarPilha();
}
