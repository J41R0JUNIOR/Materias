typedef struct No{
    float valor;
    struct No* proximo_no;
} No;

No* no(float valor, No* proximo_no);
void lista_inserir_no(No* head, No* tail, float valor);
void lista_imprimir(No* H);
void lista_liberar(No* H);
int lista_qtd(No* H);

//novas
int lista_verificar_existencia(No* L, float valor_busca);
int lista_verificar_ocorrencias(No* L, float valor_busca);
void lista_imprimir_inversa(No* L);
void lista_inserir_no_i(No* L, int i, float valor);
void atualizar_indices(No* L);
void lista_remover_no_i(No* L, int i);
void lista_remover_no(No* L, float valor_busca);

//nova
void lista_inserir_no_ordenado(No* L, No* no);