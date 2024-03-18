package GreedyALgorithms;


import java.util.*;

/*   https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1     */

public class FractionKnapsack {

    public static void FractionalKnapsack(int[] w, int[] v, int W)
    {
        int[][] a = new int[w.length][3];
        for(int i=0;i<a.length;i++)
        {
            a[i][0] = w[i];
            a[i][1] = v[i];
            a[i][2] = v[i]/w[i];
        }
        Arrays.sort(a,Comparator.comparingDouble(o->o[2]));
        int profit = 0;
        for(int i=a.length-1;i>=0;i--)
        {
            if(W>=a[i][0])
            {
                profit += a[i][1];
                W -= a[i][0];
            }
            else
            {
                profit += W*a[i][2];
                break;
            }
        }
        System.out.println(profit);
    }


    /*  SOLUTION  */
    
    // double fractionalKnapsack1(int W, Item arr[], int n) 
    // {
    //     // Your code here
    //     double[][] a = new double[n][2];
    //     for(int i=0;i<a.length;i++)
    //     {
    //         a[i][0] = i;
    //         a[i][1] = arr[i].value/(double)(arr[i].weight);
    //     }
    //     Arrays.sort(a, Comparator.comparingDouble(o->o[1]));
    //     double profit = 0;
    //     for(int i=a.length-1;i>=0;i--)
    //     {
    //         int ind = (int)(a[i][0]);
    //         if(W>=arr[ind].weight)
    //         {
    //             profit += arr[ind].value;
    //             W -= arr[ind].weight;
    //         }
    //         else
    //         {
    //             profit += W*a[i][1];
    //             break;
    //         }
    //     }
    //     return profit;
    // }


    public static void main(String[] args) {
        int[][] a = {{7,39},{10,39},{6,60},{1,12}};
        Arrays.sort(a,Comparator.comparingDouble(o->o[1]));
        int[] w = {10,20,30};
        int[] v = {60,100,120};
        FractionalKnapsack(w, v, 50);
    }
}
