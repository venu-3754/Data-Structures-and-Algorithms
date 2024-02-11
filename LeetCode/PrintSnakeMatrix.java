package LeetCode;

import java.util.*;
public class PrintSnakeMatrix {
    
    public static void PrintArray(int[][] a){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void SnakePattern(int[][] a){
        
        int i = 0;
        if(a[i].length%2==0){
            for(i=0;i<a[0].length-1;i++){
                for(int j=0;j<a.length-1;j++){
                    System.out.print(a[i][j]+" ");
                }
                System.out.println();
            }
        }
        else{
            for(i=a[0].length-1;i>=0;i--){
                for(int j=a.length-1;j>=0;j--){
                    System.out.print(a[i][j]+" ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int a[][] = new int [row][col]; 
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
                a[i][j] = sc.nextInt();
            }
        }
        sc.close();
        
        PrintArray(a);
    }
}
