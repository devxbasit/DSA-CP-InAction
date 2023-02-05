// https://leetcode.com/problems/find-peak-element/

class Solution {

    int binarySearch(int nums[], int n, int low, int high) {

        int mid = low + (high - low) / 2;

        if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == n || nums[mid] > nums[mid + 1])) {

            return mid;

        }

        if (nums[mid] < nums[mid + 1]) {

            return binarySearch(nums, n, mid + 1, high);

        }

        return binarySearch(nums, n, low, mid - 1);

    }

    public int findPeakElement(int[] nums) {

        return binarySearch(nums, nums.length - 1, 0, nums.length - 1);

    }
}