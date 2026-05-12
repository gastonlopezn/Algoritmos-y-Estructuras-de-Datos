package java.sorting;

public class QuickSort extends Sorting {
    

    @Override
    // Método de ordenamiento que se llama para ordenar el arreglo completo
    public void sort(Comparable[] a)
    {
        sort(a, 0, a.length - 1);                 // Llama al método de ordenamiento con los índices iniciales y finales del arreglo
    }

    // Método de ordenamiento recursivo que implementa el algoritmo Quick Sort
    private void sort(Comparable[] a, int p, int r) 
    {

        if( p < r){                         // Si el índice inicial es menor que el índice final, entonces hay elementos para ordenar
            int q = partition(a, p, r);     // Particiona el arreglo y obtiene el índice del pivote después de la partición
            sort(a, p, q-1);                // Ordena recursivamente la sublista izquierda del pivote
            sort(a, q+1, r);                // Ordena recursivamente la sublista derecha del pivote
        }

    }
    
    // Método de partición que organiza el arreglo alrededor de un pivote
    private int partition(Comparable[] a, int p, int r){

        Comparable x = a[r];                        // El pivote es el último elemento del arreglo
        int i = p - 1;                              // Índice para el elemento más pequeño encontrado
        for (int j = p; j < r; j++) {
            if (a[j].compareTo(x) <= 0) {           // Si el elemento actual es menor o igual al pivote
                i++;
                exch(a, i, j);                      // Intercambia el elemento más pequeño encontrado con el elemento actual
            }
        }
        exch(a, i+1, r);                            // Intercambia el pivote con el elemento siguiente al último elemento más pequeño encontrado
        return i+1;                                 // Devuelve el índice del pivote después de la partición

    }



}
