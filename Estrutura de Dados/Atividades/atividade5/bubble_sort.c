#include "bubble_sort.h"
#include <string.h>
#define MAX_WORD_LENGTH 100

void swap(char* a, char* b) {
    char temp[MAX_WORD_LENGTH];
    strcpy(temp, a);
    strcpy(a, b);
    strcpy(b, temp);
}

void bubbleSort(char arr[][MAX_WORD_LENGTH], int n) {
    int i, j;
    for (i = 0; i < n - 1; i++) {
        for (j = 0; j < n - i - 1; j++) {
            if (strcmp(arr[j], arr[j + 1]) > 0) {
                swap(arr[j], arr[j + 1]);
            }
        }
    }
}
