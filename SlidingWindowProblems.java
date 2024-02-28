import java.util.ArrayList;

public class SlidingWindowProblems {
    
    /*   https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1  */
    /*   1st Q. They'll give k value of sub array size(Sliding Window Size) and check the maximum subarray */
    /*      1st Type Solution */
    public static long Solution1(int K,int N, ArrayList<Integer> Arr)
    {
        int left=0;
        int right = K;
        long maxsum = Integer.MIN_VALUE;
        long sum = 0;
        for(int i = 0;i<K;i++)
        {
            sum+=Arr.get(i);
        }
        maxsum = Math.max(sum,maxsum);
        while(right<N)
        {
            sum+=Arr.get(right);
            sum-=Arr.get(left);
            left++;
            maxsum = Math.max(sum,maxsum);
            right++;
        }
        return maxsum;
    }

    /*    2nd type solution  */
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N)
    {
        int left = 0;
        int right = 0;
        long maxsum = 0;
        long sum = 0;
        while(right<N)
        {
            sum+=Arr.get(right);
            if(right-left+1<K) right++;
            else
            {
                maxsum = Math.max(sum,maxsum);
                sum-=Arr.get(left);
                left++;
                right++;
            }
        }
        return maxsum;
    }




    /*  https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1   */
    /*  2nd Q. They'll give window size as K and we should print the first negative integer in every window  */
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        ArrayList<Long> neg = new ArrayList<>();
        long[] ans = new long[N-K+1];
        int left = 0;
        int right = 0;
        int k = 0;
        int z = 0;
        while(right<N)
        {
            if(A[right]<0) neg.add(A[right]);
            if(right-left+1==K)
            {
                if(k==neg.size()) ans[z++] = 0;
                else ans[z++] = neg.get(k);
                if(k!=neg.size() && A[left]==neg.get(k)) k++;
                left++;
            }
            right++;
        }
        return ans;
    }


    

}
