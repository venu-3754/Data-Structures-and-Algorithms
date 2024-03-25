

/*   https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1  */


/*   Using SLIDING WINDOW PROTOCOL    */


public class MaxSum_k_SubArray
{
    public static long Solution(int K,int N, ArrayList<Integer> Arr)
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
}