package LeetCode;

public class PrintSpiralMatrix {


    public static void PrintArray(int[][] a){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    
    public static void SpiralMatrix(int[][] a){
        int top = 0;
        int left = 0;
        int right = a[0].length-1;
        int bottom = a.length-1;
        
        while(left<=right && top<=bottom){
            for(int i=left;i<=right;i++){
                System.out.print(a[top][i]+" ");
            }
            top++;
            for(int i=top;i<=bottom;i++){
                System.out.print(a[i][right]+" ");
            }
            right--;
            for(int i=right;i>=left;i--){
                System.out.print(a[bottom][i]+" ");
            }
            bottom--;
            for(int i=bottom;i>=top;i--){
                System.out.print(a[i][left]+" ");
            }
            left++;
        }
    } 


    public static void main(String[] args) {
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};     
        PrintArray(a);            // 1 2 3 4 5 6 7 8 9 
        SpiralMatrix(a);          // 1 2 3 6 9 8 7 4 5
    }
}
