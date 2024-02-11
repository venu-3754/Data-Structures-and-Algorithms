package LeetCode;

/*  https://leetcode.com/problems/move-zeroes/   */


// import java.util.*;

// public class MoveZeroes {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int [] a = new int[n];
//         for (int i=0;i<n;i++){
//             a[i] = sc.nextInt();
//         }
//         moveZeroes(a);
//         PrintArray(a);
//     }
    

//     public static void moveZeroes(int[] a){
//         int left = 0;
//         int right = 0;
//         while(right<a.length){
//             if(a[right]%2!=0){
//                 int temp = a[right];
//                 a[right] = a[left];
//                 a[left] = temp;
//                 left++;
//             }
//             right++;
//         }
//     }


//     public static void PrintArray(int[] a){
//         for(int i=0;i<a.length;i++){
//             System.out.print(a[i] + " ");
//         }
//         System.out.println();
//     }
    
// }


/* LEETCODE ANSWER */
class Solution{
    public void moveZeroes(int[] a){
        int left = 0;
        int right = 0;
        while(right<a.length){
            if(a[right]!=0){
                int temp = a[right];
                a[right] = a[left];
                a[left] = temp;
                left++;
            }
            right++;
        }
    }
}