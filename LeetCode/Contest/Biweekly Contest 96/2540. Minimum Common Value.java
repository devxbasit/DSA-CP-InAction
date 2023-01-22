
// https://leetcode.com/contest/biweekly-contest-96/problems/minimum-common-value/

class Solution {
    public int getCommon(int[] nums1, int[] nums2) {

        for (int i = 0; i < nums1.length; i++) {
            if (binarySearch(nums1[i], nums2, 0, nums2.length - 1)) {
                return nums1[i];
            }
        }

        return -1;

    }

    public boolean binarySearch(int element, int[] nums, int low, int high) {

        if (low > high)
            return false;

        int mid = low + (high - low) / 2;

        if (nums[mid] == element)
            return true;

        return (nums[mid] > element) ? binarySearch(element, nums, low, mid - 1)
                : binarySearch(element, nums, mid + 1, high);

    }
}
