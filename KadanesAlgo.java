

/*Kadane's Algo is used to find MAXIMUM SUB-ARRAY SUM in given array*/

/*   https://leetcode.com/problems/maximum-subarray/  */

public class KadanesAlgo {

    public static void UnoptimizedWay(int[] a){
        int max=0;
        for(int i=0;i<a.length;i++){
            int sum = 0;
            for(int j=i;j<a.length;j++){
                sum += a[j];
                max = Math.max(max,sum);
            }
        }
        System.out.println(max);
    }


    public static void main(String[] args) {
        
        int[] a = {-2,-3,4,-1,-2,1,5,-3};
        UnoptimizedWay(a);
    }
}


    /*  LEETCODE SOLUTION  */

// class Solution {
//     public int maxSubArray(int[] nums) {
//         int n = nums.length;
//         if(n<1) return -1;
//         int max = 0;
//         for(int i=0;i<n;i++){
//             int sum = 0;
//             for(int j=i;j<n;j++){
//                 sum+=nums[j];
//                 max = Math.max(max,sum);
//             }
//         }
//         return max;
//     }
// }