#include <stdio.h>
#include <stdlib.h>

struct Ponto {
    int x;
    float y;
}typedef Ponto;

int main(int argc, char* argv[]) {
    int x;
    float y;
    int qtd;
    FILE* file;
    file = fopen("/Users/jairojunior/Documents/GitHub/Materias/Estrutura de Dados/Atividades/atividade3/dados.csv", "r");

    if (file == NULL) {
        perror("Error opening file");
        return 1;
    }

    // Read data until the end of the file
    while (fscanf(file, "%i,%f", &x, &y) != EOF) {
    //    printf("%i , %f\n", x, y);
        qtd++;
    }

    // Reset the file pointer to the beginning of the file
    fseek(file, 0, SEEK_SET);

    Ponto* pontos = (Ponto *)malloc(qtd * sizeof(Ponto));
    if(pontos == NULL){
        printf("Error alocating memory");
        return 1;
    }
    
    for (int i = 0; i < qtd; i++) {
        fscanf(file, "%i,%f", &pontos[i].x, &pontos[i].y);
        printf("\n%i, %f", pontos[i].x, pontos[i].y);
    }

    printf("\nquantidade de registros = %i\n", qtd);
    fclose(file);

    return 0;
}
