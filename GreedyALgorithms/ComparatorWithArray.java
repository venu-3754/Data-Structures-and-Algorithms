package GreedyALgorithms;

import java.util.*;
public class ComparatorWithArray {
    public static void main(String[] args) {
        int[][] a = {{10,35},{7,39},{6,60},{1,12}};
        Arrays.sort(a,Comparator.comparingDouble(o->o[0]));
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a[i].length;j++)
            {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}
