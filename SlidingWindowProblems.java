import java.util.ArrayList;
import java.util.HashMap;

public class SlidingWindowProblems {
    
    /*   https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1  */
    /*   1st Q. They'll give k value of sub array size(Sliding Window Size) and check the maximum subarray sum */
    /*      1st Type Solution */
    public static long Solution1(int K,int N, ArrayList<Integer> Arr)
    {
        int left=0;
        int right = K;
        long maxsum = Integer.MIN_VALUE; /* It means minus infinity */   /* We can set long maxsum = 0 also */
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
            maxsum = Math.max(sum,maxsum);
            right++;
            left++;
        }
        return maxsum;
    }

    /*    2nd type solution  */
    static long maximumSumSubarray2(int K, ArrayList<Integer> Arr,int N)
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


     /*  3rd type solution  */
    static long maximumSumSubarray3(int K, ArrayList<Integer> Arr,int N)
    {
        int left = 0;
        int right = 0;
        long maxsum = 0;
        long sum = 0;
        while(right<N)
        {
            sum+=Arr.get(right);
            if(!(right<K-1))
            {
                maxsum = Math.max(sum,maxsum);
                sum-=Arr.get(left);
                left++;
            }
            right++;
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


    /*   https://www.codingninjas.com/studio/problems/longest-subarray-with-sum-k_6682399?leftPanelTabValue=PROBLEM   */
    /*  3rd Q. Problem statement
        You are given an array 'a' of size 'n' and an integer 'k'.
        Find the length of the longest subarray of 'a' whose sum is equal to 'k'.
        Example :
        Input: ‘n’ = 7 ‘k’ = 3
        ‘a’ = [1, 2, 3, 1, 1, 1, 1]
        Output: 3
        Explanation: Subarrays whose sum = ‘3’ are:
        [1, 2], [3], [1, 1, 1] and [1, 1, 1]
        Here, the length of the longest subarray is 3, which is our final answer. */
    
    public static int longestSubarrayWithSumK(int []a, long k)
    {
        int left = 0;
        int right = 0;
        int ans = 0;
        long sum = 0;
        while(right<a.length)
        {
            sum +=a[right];
            if(sum==k) ans = Math.max(ans, right-left+1);
            else if(sum>k)
            {
                while(sum>k)
                {
                    sum-=a[left];
                    left++;
                }
                if(sum==k) ans = Math.max(ans, right-left+1);
            }
            right++;
        }
        return ans;
    }


    /*  https://leetcode.com/problems/longest-substring-without-repeating-characters/description/   */
    /* 4th Q. Find longest sub-string without repeating characters  */
    /* 1st TYPE SOLUTION */
    public int lengthOfLongestSubstring1(String s)
    {
        int maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        for(int right=0;right<s.length();right++)
        {
            char c1 = s.charAt(right);
            if(map.containsKey(c1))
            {
                left = Math.max(left, map.get(c1)+1);
            }
            map.put(c1, right);
            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }

    /* 2nd TYPE SOLUTION */
    

    

}
