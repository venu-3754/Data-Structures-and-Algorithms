package GreedyALgorithms;
import java.util.*;

/*    https://leetcode.com/problems/maximum-length-of-pair-chain/    */



public class LengthOfLongestChain {


    public static int findLongestChain(int[][] pairs)
    {
        Arrays.sort(pairs, Comparator.comparingDouble(o->o[1]));
        int chain = 1;
        int last = pairs[0][1];
        for(int i=0;i<pairs.length;i++)
        {
            if(last < pairs[i][0])
            {
                chain++;
                last = pairs[i][1];
            }
        }
        return chain;
    }


    public static void main(String[] args)
    {
        int[][] pairs = {{1,2},{2,3},{3,4}};
        System.out.println(findLongestChain(pairs));
    }
}
