package GreedyALgorithms;
import java.util.*;


/*       https://www.geeksforgeeks.org/problems/minimum-sum-of-absolute-differences-of-pairs/1        */


public class MinSumOfAbsDiffPairs
{

    public static void Solution(int[] a,int[] b)
    {
        long sum = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        for(int i=0;i<a.length;i++)
        {
            sum = sum + Math.abs(a[i]-b[i]);
        }
        System.out.println(sum);
    }

    
    public static void main(String[] args)
    {
        int[] a = {4,1,8,7};
        int[] b = {2,3,6,5};
        Solution(a,b);
    }
}
