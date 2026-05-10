package Java.Sorting;

public abstract class Sorting {
    
    public abstract void sort(Comparable[] a);

    protected boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    protected static void exch(Object[] a, int i, int j){
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }



}
