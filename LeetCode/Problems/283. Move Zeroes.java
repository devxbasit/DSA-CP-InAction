// https://leetcode.com/problems/move-zeroes/
class Solution {
    public void moveZeroes(int[] nums) {

        int i = -1;

        for (int j = 0; j < nums.length; j++) {

            if (nums[j] != 0)
                nums[++i] = nums[j];

        }

        i++;

        while (i < nums.length)
            nums[i++] = 0;

    }
}