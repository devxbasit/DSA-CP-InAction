// https://practice.geeksforgeeks.org/problems/quick-left-rotation3806/1
class Solution {
    void leftRotate(long nums[], int k, int n) {

        k = k % nums.length;

        if (k == 0)
            return;

        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);

    }

    public void reverse(long[] nums, int low, int high) {

        while (low < high) {

            long temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;

            low++;
            high--;
        }

    }
}