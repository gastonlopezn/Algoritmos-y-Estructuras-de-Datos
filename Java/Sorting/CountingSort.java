package java.sorting;

public class CountingSort {
    
   public static int[] countingSort(int[] arr, int k) {
    
        int[] res = new int[arr.length];
        int[] c = new int[k+1];

        for (int i: arr) {
            c[i]++;
        }

        for (int i = 1; i < c.length; i++) {
            c[i]+= c[i-1];
        }

        for (int i = arr.length-1; i >= 0; i--) {
            res[c[arr[i]]-1] = arr[i];
            c[arr[i]]--;
        }

        return res;
    }

}