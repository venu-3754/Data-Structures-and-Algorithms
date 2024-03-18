package GreedyALgorithms;
import java.util.*;

/*  in this problem we need to find out how many activities can be picked atmost in a given starting and ending time */

/*     https://www.geeksforgeeks.org/problems/activity-selection-1587115620/1     */

public class ActivitySelection
{    

    public static int MaxActivities(int[]start, int[] end)
    {
        int[][] a = new int[start.length][2];
        for(int i=0;i<a.length;i++)
        {
            a[i][0] = start[i];
            a[i][1] = end[i];
        }
        Arrays.sort(a,Comparator.comparingDouble(o->o[1]));
        int MaxAct = 1;
        int lastAct = a[0][1];
        for(int i=0;i<a.length;i++)
        {
            if(lastAct<a[i][0])
            {
                MaxAct++;
                lastAct = a[i][1];
            }
        }
        return MaxAct;
    }


    public static void main(String[] args) {
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,6,7,9,9};
        System.out.println(MaxActivities(start, end));

    }
}
