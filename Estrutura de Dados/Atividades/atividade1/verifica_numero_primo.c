#include <stdio.h>
#include <stdlib.h>

int main(int argc, char* argv[]){
    
    int verificar(int n);
    int n = 0;

    n = atoi(argv[1]); 


    if(verificar(n) == 1){
        printf("Numero Primo");
    }else{
        printf("Numero Nao Primo");
    }

    return 0;
    
}

int verificar(int n){
    int qtd = 0;

    if (n == 2){
        return 1;
    }

    if((n % 2) != 0){
        for(int i = n ; i != 0; i--){
            if((n % i) == 0){
                qtd++;
                if(qtd>=3){
                    return 0;
                }
            }
        }  

        if(qtd <= 2){
            return 1;
        }else{
            return 0;
        }
    }else{
        return 0;
    }
}
//gcc -o verifica_numero_primo verifica_numero_primo.c
//./verifica_numero_primo 123456