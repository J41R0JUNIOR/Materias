#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "lista.h"

No* no(char valor, No* proximo_no){
    No* no = malloc(sizeof(No));
    no->valor = valor;
    no->proximo_no = proximo_no;
    return no;
}

void lista_inserir_no(No* H, No* no){
    if(H != NULL){
        if(H->proximo_no == NULL){
            H->proximo_no = no;
        }else{
            lista_inserir_no(H->proximo_no, no);  
        }
    }
}

void lista_imprimir(No* H){
    if(H != NULL){
        printf("%c || ", H->valor);
        lista_imprimir(H->proximo_no);
    }
  
}

void lista_liberar(No* H){
    if(H != NULL){
        lista_liberar(H->proximo_no);
        free(H);
    }
}

int lista_qtd(No* H){
    if(H != NULL){
        return 1 + lista_qtd(H->proximo_no);
    }
    return 0;
}

int lista_verificar_existencia(No* L, char valor_busca){
    if (L != NULL) {
        if (L->valor == valor_busca) {
            return 1;
        } else {
            return lista_verificar_existencia(L->proximo_no, valor_busca);
        }
    }
    return 0;
}

int lista_verificar_ocorrencias(No* L, char valor_busca){
    if(L != NULL){
        if(L->valor == valor_busca){
            return 1 + lista_verificar_ocorrencias(L->proximo_no, valor_busca);
        }else{
            return lista_verificar_ocorrencias(L->proximo_no, valor_busca);
        }
    }
    return 0;
}

void lista_imprimir_inversa(No* L) {
    if (L != NULL) {
        lista_imprimir_inversa(L->proximo_no);
        printf("%c || ", L->valor);
    }
}

// void lista_inserir_no(No* H, No* no){
//     if(H != NULL){
//         if(H->proximo_no == NULL){
//             H->proximo_no = no;
//         }else{
//             lista_inserir_no(H->proximo_no, no);  
//         }
//     }
// }


void lista_inserir_no_i(No* L, int i, char valor){
    No* novo_no = no(valor, NULL);

    if (i == 0) {
        novo_no->proximo_no = L;
        L = novo_no;
    } else {
        No* atual = L;
        int posicao = 0;

        while (atual != NULL && posicao < i - 1) {
            atual = atual->proximo_no;
            posicao++;
        }

        if (atual != NULL) {
            novo_no->proximo_no = atual->proximo_no;
            atual->proximo_no = novo_no;

           
        } else {
            while (atual->proximo_no != NULL) {
                atual = atual->proximo_no;
            }
            atual->proximo_no = novo_no;
          
        }
    }
}

// void lista_remover_no_i(No* L, int i){
//     No* atual = L;
//     No* proximo = atual->proximo_no;

//     if(L != NULL){
//         if(atual->indice = i){
//             atual->valor = proximo->valor;
//             atual->proximo_no = proximo->proximo_no;
//             proximo->proximo_no = NULL;
//         }
//     }

// }

void lista_remover_no_i(No* L, int i) {
    if (i < 0) {
        printf("Índice inválido.\n");
        return;
    }

    No* atual = L;
    No* anterior = NULL;
    int indice = 0;

    while (atual != NULL && indice < i) {
        anterior = atual;
        atual = atual->proximo_no;
        indice++;
    }

    if (atual == NULL) {
        printf("Índice fora dos limites da lista.\n");
        return;
    }

    if (anterior == NULL) {
        L = atual->proximo_no;
    } else {
        anterior->proximo_no = atual->proximo_no;
    }

    free(atual);
}

void lista_remover_no(No* L, char valor_busca) {
    No* atual = L;
    No* anterior = NULL;
    No* proximo = NULL;

    while (atual != NULL) {
        if (atual->valor == valor_busca) {
            proximo = atual->proximo_no;
            free(atual);

            if (anterior == NULL) {
                L = proximo;
            } else {
                anterior->proximo_no = proximo;
            }

            atual = proximo;
        } else {
            anterior = atual;
            atual = atual->proximo_no;
        }
    }
}
