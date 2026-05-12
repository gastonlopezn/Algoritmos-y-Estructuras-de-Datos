

//Implementación de Quick Sort en C
#include <stdio.h>

void swap(int* a, int* b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

int partition(int arr[], int low, int high) {
    int pivot = arr[high]; // Elegimos el último elemento como pivote
    int i = low - 1; // Índice del elemento más pequeño

    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) { // Si el elemento actual es menor que el pivote
            i++; // Incrementamos el índice del elemento más pequeño
            swap(&arr[i], &arr[j]); // Intercambiamos el elemento más pequeño encontrado con el elemento actual
        }
    }
    swap(&arr[i + 1], &arr[high]); // Intercambiamos el pivote con el elemento siguiente al último elemento más pequeño encontrado
    return i + 1; // Devolvemos el índice del pivote después de la partición
}

void quickSort(int arr[], int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high); // Particionamos el arreglo y obtenemos el índice del pivote

        quickSort(arr, low, pi - 1); // Ordenamos recursivamente la sublista izquierda del pivote
        quickSort(arr, pi + 1, high); // Ordenamos recursivamente la sublista derecha del pivote
    }
}

int main() {
    int arr[] = {10, 7, 8, 9, 1, 5};
    int n = sizeof(arr) / sizeof(arr[0]);
    quickSort(arr, 0, n - 1);
    printf("Array ordenado: \n");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    return 0;
}