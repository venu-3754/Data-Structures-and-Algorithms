package LeetCode;

/*  https://leetcode.com/problems/two-sum/submissions/1162160506/   */
/* LEETCODE SOUTION */

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for(int i=1; i<nums.length; i++){
            for (int j=0 ; i+j<nums.length; j++){
                if(nums[i+j]+nums[j] == target){
                    return new int[] {i+j,j} ;
                }
            }
        }
        return new int[]{};
    }
}
