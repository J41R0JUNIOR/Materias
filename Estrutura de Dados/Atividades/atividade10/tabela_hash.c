#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "tabela_hash.h"

typedef struct Entrada {
    char* chave;
    char* dado;
    struct Entrada* proximo;
} Entrada;

Entrada* tabela[TAMANHO_TABELA];

void hash_table_init() {
    for (int i = 0; i < TAMANHO_TABELA; i++) {
        tabela[i] = NULL;
    }
}

int hash(char* chave) {
    int hash = 0;
    for (int i = 0; chave[i] != '\0'; i++) {
        hash = (hash + chave[i]) % TAMANHO_TABELA;
    }
    return hash;
}

char* hash_table_get(char* chave) {
    int indice = hash(chave);
    Entrada* entrada = tabela[indice];

    while (entrada != NULL) {
        if (strcmp(entrada->chave, chave) == 0) {
            return entrada->dado;
        }
        entrada = entrada->proximo;
    }

    return NULL;
}

void hash_table_put(char* chave, char* dado) {
    int indice = hash(chave);
    Entrada* nova_entrada = (Entrada*)malloc(sizeof(Entrada));
    nova_entrada->chave = chave;
    nova_entrada->dado = dado;
    nova_entrada->proximo = tabela[indice];
    tabela[indice] = nova_entrada;
}

int hash_table_contains(char* chave) {
    return hash_table_get(chave) != NULL;
}

void hash_table_remove(char* chave) {
    int indice = hash(chave);
    Entrada* entrada = tabela[indice];
    Entrada* anterior = NULL;

    while (entrada != NULL) {
        if (strcmp(entrada->chave, chave) == 0) {
            if (anterior != NULL) {
                anterior->proximo = entrada->proximo;
            } else {
                tabela[indice] = entrada->proximo;
            }
            free(entrada);
            return;
        }
        anterior = entrada;
        entrada = entrada->proximo;
    }
}
