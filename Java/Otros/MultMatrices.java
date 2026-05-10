package Java.Otros;

public class MultMatrices{


    public MultMatrices(){}


    public static int[][] multiply(int [][] a, int [][]b)
    {
        int[][] result = new int[a.length][b[0].length];
        if(a[0].length == b.length){
            for(int i = 0; i < a.length; i++){
                for (int j = 0; j < b[0].length; i++) {
                    for (int k = 0; k < a[0].length; k++) {
                        result[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
        }
        return result;
    }




}
