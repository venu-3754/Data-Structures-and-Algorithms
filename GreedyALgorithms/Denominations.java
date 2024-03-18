package GreedyALgorithms;
import java.util.*;

/*  https://www.geeksforgeeks.org/problems/-minimum-number-of-coins4426/1    */


public class Denominations {
    static List<Integer> minPartition(int N)
    {
        // code here
        int[] a = {1,2,5,10,20,50,100,200,500,2000};
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=a.length-1;i>=0;i--)
        {
            if(a[i] <= N)
            {
                while(a[i] <= N)
                {
                    ans.add(a[i]);
                    N -= a[i];
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(minPartition(N));
        
        sc.close();
    }
}
