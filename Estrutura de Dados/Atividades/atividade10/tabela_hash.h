#define TAMANHO_TABELA 100

typedef struct Entrada {
    char* chave;
    char* dado;
    struct Entrada* proximo;
} Entrada;

Entrada* tabela[TAMANHO_TABELA];

int hash(char* chave);
void hash_table_init();
char* hash_table_get(char* chave);
void hash_table_put(char* chave, char* dado);
int hash_table_contains(char* chave);
void hash_table_remove(char* chave);
