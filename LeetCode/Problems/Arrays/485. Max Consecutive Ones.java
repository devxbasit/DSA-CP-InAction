// https://leetcode.com/problems/max-consecutive-ones/description/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int max = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                
                max = Math.max(sum, max);
                sum = 0;

            }  else  {

                sum += nums[i];
                
            }

        }
        
        return Math.max(sum, max);
    }
}