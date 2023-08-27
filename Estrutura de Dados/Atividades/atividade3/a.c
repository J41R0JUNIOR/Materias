#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int x;
    float y;
} Ponto;

int main(int argc, char *argv[]) {
    if (argc != 2) {
        printf("Uso: %s <arquivo.csv>\n", argv[0]);
        return 1;
    }

    FILE *arquivo = fopen(argv[1], "r");
    if (arquivo == NULL) {
        printf("Erro ao abrir o arquivo.\n");
        return 1;
    }

    int capacidade = 10;  // Capacidade inicial do array de pontos
    int numPontos = 0;
    Ponto *pontos = (Ponto *)malloc(capacidade * sizeof(Ponto));
    if (pontos == NULL) {
        printf("Erro na alocação de memória.\n");
        return 1;
    }

    while (fscanf(arquivo, "%d,%f", &pontos[numPontos].x, &pontos[numPontos].y) != EOF) {
        numPontos++;

        // Redimensionar o array de pontos se necessário
        if (numPontos >= capacidade) {
            capacidade *= 2;
            Ponto *temp = (Ponto *)realloc(pontos, capacidade * sizeof(Ponto));
            if (temp == NULL) {
                printf("Erro na realocação de memória.\n");
                free(pontos);
                return 1;
            }
            pontos = temp;
        }
    }

    fclose(arquivo);

    // Calcular média dos valores de x e y
    int somaX = 0;
    float somaY = 0.0;
    for (int i = 0; i < numPontos; i++) {
        somaX += pontos[i].x;
        somaY += pontos[i].y;
    }
    float mediaX = (float)somaX / numPontos;
    float mediaY = somaY / numPontos;

    // Calcular inclinação e interceptação da regressão linear
    float somaXY = 0.0, somaXX = 0.0;
    for (int i = 0; i < numPontos; i++) {
        somaXY += (pontos[i].x - mediaX) * (pontos[i].y - mediaY);
        somaXX += (pontos[i].x - mediaX) * (pontos[i].x - mediaX);
    }
    float coeficienteAngular = somaXY / somaXX;
    float coeficienteLinear = mediaY - coeficienteAngular * mediaX;

    // Exibir a equação da regressão linear
    printf("Saída: y = %.2fx + %.2f\n", coeficienteAngular, coeficienteLinear);

    // Liberar memória alocada
    free(pontos);

    return 0;
}
