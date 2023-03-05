// https://leetcode.com/problems/move-zeroes/description/

// The idea is that we go through the array and gather all zeros on our road.
// https://leetcode.com/problems/move-zeroes/solutions/172432/the-easiest-but-unusual-snowball-java-solution-beats-100-o-n-clear-explanation/

class Solution {
    public void moveZeroes(int[] nums) {

        int snowBallSize = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {

                snowBallSize++;

            } else if (snowBallSize > 0) {

                swap(nums, i - snowBallSize, i);

            }

        }
    }

    public void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }
}