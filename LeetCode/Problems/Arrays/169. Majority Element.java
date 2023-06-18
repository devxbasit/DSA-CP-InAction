// https://leetcode.com/problems/majority-element/ 

//Boyer-Moore Majority Voting Algorithm - https://www.geeksforgeeks.org/boyer-moore-majority-voting-algorithm/
class Solution {
    public int majorityElement(int[] nums) {

        int votes = 0;
        int candidate = -1;

        int n = nums.length / 2;

        for (int i = 0; i < nums.length; i++) {

            if (votes == 0) {
                candidate = nums[i];
                votes = 1;
                continue; 
            }

            if (candidate == nums[i]) votes++; else votes--;

            if (votes > n) return candidate;
            
        }
       
       return candidate;
        
    }
}

// Approach 2
class Solution {

    public int majorityElement(int[] nums) {

        Arrays.sort(nums);
        return nums[nums.length / 2];

    }
}

// Approach 3 - Frequency Count
