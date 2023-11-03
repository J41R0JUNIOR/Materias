#include <stdio.h>
#include "tabela_hash.h"

int main() {
    hash_table_init();

    hash_table_put("chave1", "valor1");
    hash_table_put("chave2", "valor2");

    char* valor1 = hash_table_get("chave1");
    char* valor2 = hash_table_get("chave2");

    printf("Valor associado à chave1: %s\n", valor1);
    printf("Valor associado à chave2: %s\n", valor2);

    if (hash_table_contains("chave1")) {
        printf("A chave1 está na tabela.\n");
    } else {
        printf("A chave1 não está na tabela.\n");
    }

    hash_table_remove("chave1");

    if (hash_table_contains("chave1")) {
        printf("A chave1 está na tabela.\n");
    } else {
        printf("A chave1 não está na tabela.\n");
    }

    return 0;
}
