package Java.Sorting;

public class BubbleSort extends Sorting{

    public BubbleSort(){}


    @Override
    public void sort(Comparable[] a)
    {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int exchanges = 0;
            for (int j = n-1; j > i; j--){
                if(less(a[j], a[j-1])){
                    exch(a, j, j-1);
                    exchanges++;
                }
            }
        if (exchanges == 0) break;
        }

    }




    
}
