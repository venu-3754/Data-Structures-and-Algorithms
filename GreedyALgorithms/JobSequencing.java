package GreedyALgorithms;

import java.util.Arrays;
import java.util.Comparator;


/*  https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1   */


class Job
{
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}


public class JobSequencing {
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        int[][] a = new int[arr.length][2];
        int MaxDays = 0;
        for(int i=0;i<arr.length;i++)
        {
            MaxDays = Math.max(MaxDays,arr[i].deadline);
            a[i][0] = arr[i].deadline;
            a[i][1] = arr[i].profit;
        }

        Arrays.sort(a, Comparator.comparingDouble(o->o[1]));

        int[] check = new int[MaxDays];
        int profit = 0;
        int job = 0;
        for(int i=a.length-1;i>=0;i--)
        {
            int ind = a[i][0]-1;
            while(ind>=0 && check[ind]!=0)
            {
                ind--;
            }
            if(ind>=0 && check[ind] == 0)
            {
                profit += a[i][1];
                job++;
                check[ind] = -1;
            }
        }
        int[] ans = new int[2];
        ans[0] = job;
        ans[1] = profit;
        return ans;
    }


}
