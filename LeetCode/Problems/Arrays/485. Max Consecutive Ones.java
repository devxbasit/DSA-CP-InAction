// https://leetcode.com/problems/max-consecutive-ones/description/


class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int i = 0, j = 0;
        int maxOnesCount = 0;

        for (; j < nums.length; j++) {

            if (nums[j] == 0) {
                
               maxOnesCount = Math.max(maxOnesCount, j - i);
                i = j + 1;
            } 
        }

        return Math.max(maxOnesCount, j - i);
            
        
    }
}
 
 // approach 2
 class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int maxOnesCount = 0, counter = 0;

        for (int i = 0; i < nums.length; i++) {
            
            if (nums[i] == 1) {
                counter++; 
                continue;
            }

            if (counter > maxOnesCount) maxOnesCount = counter;

            counter = 0;
        }

        return counter > maxOnesCount ? counter : maxOnesCount;
        
    }
}