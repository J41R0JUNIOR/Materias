#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "bubble_sort.h"

#define MAX_WORD_LENGTH 100

int main(int argc, char* argv[]) {
    if (argc != 2) {
        printf("Uso: %s <arquivo_entrada>\n", argv[0]);
        return 1;
    }

    FILE* inputFile = fopen(argv[1], "r");
    if (inputFile == NULL) {
        perror("Erro ao abrir o arquivo de entrada");
        return 1;
    }

    char words[10][MAX_WORD_LENGTH];
    int wordCount = 0;

    while (fscanf(inputFile, "%s", words[wordCount]) == 1) {
        wordCount++;
    }

    fclose(inputFile);

    bubbleSort(words, wordCount);

    FILE* outputFile = fopen("arq_palavras_ordenado.txt", "w");
    if (outputFile == NULL) {
        perror("Erro ao criar o arquivo de saída");
        return 1;
    }

    for (int i = 0; i < wordCount; i++) {
        fprintf(outputFile, "%s\n", words[i]);
    }

    fclose(outputFile);

    printf("Palavras ordenadas e salvas em 'arq_palavras_ordenado.txt'\n");

    return 0;
}
