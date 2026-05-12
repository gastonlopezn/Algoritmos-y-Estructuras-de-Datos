package java.sorting;

public class RadixSort {

    //Implementación del algoritmo de ordenamiento Radix Sort
    public void sort(int [] arr, int d) {
        for(int i = 0; i < d; i++) {
            CountingSort.countingSort(arr, i);
        }
    }

}
