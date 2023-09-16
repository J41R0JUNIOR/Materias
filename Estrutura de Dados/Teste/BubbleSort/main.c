#include <stdio.h>
#include <stdlib.h>
#include "bubble_sort.h"

void imprimir_arr(int *arr, int n){
    for(int i = 0; i < n;i++){
        printf("%d - ", arr[i]); 
    }
    printf("\n");
}


int main(int argc, char* argv[]){

    int arr[] = {7,5,89,4,75,4,6,3,7,20,5,8,63,546,};
    int n = sizeof(arr) / sizeof(int);

    imprimir_arr(arr,n);
    bubble_sort(arr,n);
    imprimir_arr(arr,n);

    return 0;
}
/*
gcc main.c bubble_sort.c -o main
./main 
*/