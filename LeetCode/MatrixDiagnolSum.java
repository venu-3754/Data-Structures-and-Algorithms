package LeetCode;

public class MatrixDiagnolSum {
    

    public static void PrintArray(int[][] a){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};     
        PrintArray(a);            // 1 2 3 4 5 6 7 8 9    OP : 27
    }
}
