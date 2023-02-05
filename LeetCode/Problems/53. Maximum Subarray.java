//https://leetcode.com/problems/maximum-subarray/
class Solution {
    public int maxSubArray(int[] nums) {

        int dp[] = new int[nums.length];

        dp[0] = nums[0];

        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {

            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);

            max = Math.max(max, dp[i]);

        }

        return max;

        // same approach, but without dp array

        // int prev = nums[0];

        // int max = nums[0];

        // int sum;
        // for (int i = 1; i < nums.length; i++) {

        // sum = Math.max(prev + nums[i], nums[i]);

        // max = Math.max(max, sum);

        // prev = sum;

        // }

        // return max;

        // Another way of doing

        // int maxSoFar = nums[0];

        // int currMax = nums[0];
        // for (int i = 1; i < nums.length; i++) {

        // currMax = Math.max(currMax + nums[i], nums[i]);
        // maxSoFar = Math.max(currMax, maxSoFar);

        // }

        // return maxSoFar;

        // Another of doing
        //

        int maxSoFar = Integer.MIN_VALUE;
        int currMax = 0;

        for (int i = 0; i < nums.length; i++) {

            currMax += nums[i];

            maxSoFar = Math.max(currMax, maxSoFar);

            // if currMax is less then 0, then reset and start again

            if (currMax < 0) {

                currMax = 0;

            }

        }

        return maxSoFar;

    }
}