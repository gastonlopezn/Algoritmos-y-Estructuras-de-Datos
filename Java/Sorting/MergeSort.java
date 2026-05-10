package Java.Sorting;

public class MergeSort extends Sorting{
    
    public MergeSort(){}

    @Override
    public void sort(Comparable[] a)
    {
        if(a.length <= 1) return;

        int mid  = a.length /2;

        Comparable[] left = copyRange(a, 0, mid);
        Comparable[] right = copyRange(a, mid, a.length);

        sort(left);
        sort(right);

        merge(left,right, a);
 
    }

    public Comparable[] copyRange(Comparable[] a, int from, int to)
    {
        Comparable[] copy = new Comparable[to - from];

        for (int i = 0; i < copy.length; i++) {
            copy[i] = a[from + i];
        }

        return copy;
    }

    private void merge(Comparable[] left, Comparable[] right, Comparable[] res)
    {
        int i = 0, j = 0, k= 0;

        // Compare and take the smaller element
        while (i < left.length && j < right.length) {
            if (left[i].compareTo((right[j])) <= 0) {
                res[k] = left[i];
                i++;
            }else{
                res[k] = right[j];
                j++;
            }
            k++;
        }

        // Add any leftovers from the left array
        while (i < left.length) {
            res[k] = left[i];
            i++;
            k++;
        }

        // Add any leftovers from the right array
        while (j < right.length) {
            res[k] = right[j];
            j++;
            k++;
        }
    }

}
