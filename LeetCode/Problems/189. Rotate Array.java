// https://leetcode.com/problems/rotate-array/
class Solution {
    void reverse(int nums[], int low, int high) {

        while (low < high) {

            int temp = nums[low];

            nums[low] = nums[high];
            nums[high] = temp;

            low++;
            high--;

        }

    }

    public void rotate(int[] nums, int k) {

        k = k % nums.length;

        if (k == 0)
            return;

        reverse(nums, 0, nums.length - 1);

        if (k == nums.length)
            return;

        reverse(nums, 0, k - 1);

        reverse(nums, k, nums.length - 1);

    }
}