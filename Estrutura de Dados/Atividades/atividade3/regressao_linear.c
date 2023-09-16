#include <stdio.h>
#include <stdlib.h>

struct Ponto {
    int x;
    float y;
}typedef Ponto;

int main(int argc, char* argv[]) {
    int x = 0;
    float y = 0;
    int qtd = 0;

    FILE* file;
    file = fopen(argv[1], "r");

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
    printf("\nmedia x = %f, media y = %f", mediaX, mediaY);

    //(coeficiente angular)
    //inclinacao 
    float sumXY = 0, sumXX = 0;

   for (int i = 0; i < qtd; i++) {
        sumXY += (pontos[i].x - mediaX) * (pontos[i].y - mediaY);
        sumXX += (pontos[i].x - mediaX) * (pontos[i].x - mediaX);
    }

    float inclinacao = sumXY / sumXX;
    printf("\n inclinacao = %f", inclinacao);

    //(coeficiente linear)
    //intercepcao
    float intercepcao = mediaY - inclinacao * mediaX;
    printf("\n intercepcao = %f", intercepcao);

    printf("\n ------------ resultado final --------------- \n");
    printf("\ny = %.2f * x + %.2f", inclinacao, intercepcao);
    return 0;
}