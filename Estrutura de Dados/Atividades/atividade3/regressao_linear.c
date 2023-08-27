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

    while (fscanf(file, "%i,%f", &x, &y) != EOF) {
       qtd++;
    }
    x = 0;
    y = 0;

    // Reset the file pointer to the beginning of the file
    fseek(file, 0, SEEK_SET);

    Ponto* pontos = (Ponto *)malloc(qtd * sizeof(Ponto));
    if(pontos == NULL){
        printf("Error alocating memory");
        return 1;
    }
    
    for (int i = 0; i < qtd; i++) {
        fscanf(file, "%i,%f", &pontos[i].x, &pontos[i].y);
        fflush(stdin);
    //    printf("\n%i, %f", pontos[i].x, pontos[i].y);
    }

    printf("\nquantidade de registros = %i\n", qtd);
    fclose(file);

    //media x e y
    for(int i = 0; i < qtd; i++){
        x += pontos[i].x;
        y += pontos[i].y;
    }
 
    float mediaX = (float)x / qtd;
    float mediaY = y / qtd;
    printf("\ntotal x = %d, total y = %f", x, y);
    printf("\nmedia x = %i, media y = %f", mediaX, mediaY);

    //(coeficiente angular)
    //inclinacao 
    float inclinacao;
    for(int i = 0; i < qtd; i++){
        inclinacao = (pontos[i].x - mediaX) * (pontos[i].y - mediaY) / ((pontos[i].x - mediaX) * (pontos[i].x - mediaX));
    }

    printf("\n inclinacao = %f", inclinacao);

    //(coeficiente linear)
    //intercepcao
    float intercepcao = mediaY - inclinacao * mediaX;
    printf("\n intercepcao = %f", intercepcao);

    return 0;
}
