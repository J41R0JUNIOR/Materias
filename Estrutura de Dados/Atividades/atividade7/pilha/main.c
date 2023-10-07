#include <stdio.h>
#include <stdlib.h>
#include "pilha.h"

int main() {
    Pilha* pilhas[5];
    for (int i = 0; i < 5; i++) {
        pilhas[i] = criarPilhaPrioridade();
    }

    Paciente paciente1 = {"Remmis", 2};
    Paciente paciente2 = {"Joao Pedro Macleure", 4};
    Paciente paciente5 = {"João Evangelista", 2};
    Paciente paciente3 = {"Sebastiao Cleto", 1};
    Paciente paciente6 = {"Edilson", 4};
    Paciente paciente4 = {"Diego", 0};

    push(pilhas[paciente1.prioridade], paciente1);
    push(pilhas[paciente2.prioridade], paciente2);
    push(pilhas[paciente3.prioridade], paciente3);
    push(pilhas[paciente4.prioridade], paciente4);
    push(pilhas[paciente5.prioridade], paciente5);
    push(pilhas[paciente6.prioridade], paciente6);

    for (int i = 4; i >= 0; i--) {
        printf("Pacientes com prioridade %d:\n", i);

        printf("Nomes:");
        while (pilhas[i]->top != NULL) {
            Paciente paciente = pop(pilhas[i]);
            printf("%s,", paciente.nome);
        }
        printf("\n");
    }

    return 0;
}
