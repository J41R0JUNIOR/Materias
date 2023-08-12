#include <stdio.h>

double calcularDobro(double n){
    return n*2;
}

int main (int arc, char* argv[]){

    int n = 11;
    int n2 = 0;
    float f1 = 1.5;
    double d1 = 1.55555;
    char letra = 'j';

    if(n2){
        printf("0 eh verdadeiro\n");
    }
    if(n){
        printf("11 eh verdadeiro");
    }

    printf("O dobro de %lf eh %lf", d1, calcularDobro(d1));

    return 0;
}