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

    int arr[] = {54,26,93,17,77,31,44,55,20};
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