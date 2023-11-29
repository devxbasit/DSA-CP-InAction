// https://leetcode.com/problems/search-in-rotated-sorted-array/
class Solution {

  public int search(int[] nums, int target) {
    return binarySearch(nums, 0, nums.length - 1, target);
  }

  public int binarySearch(int[] nums, int low, int high, int target) {
    if (low <= high) {
      int mid = low + (high - low) / 2;

      if (nums[mid] == target) return mid;

      // one half will be sorted and one not

      // check if left half is sorted
      if (nums[low] <= nums[mid]) {
        return (target >= nums[low] && target < nums[mid])
          ? binarySearch(nums, low, mid - 1, target)
          : binarySearch(nums, mid + 1, high, target);
      } else {
        return (target > nums[mid] && target <= nums[high])
          ? binarySearch(nums, mid + 1, high, target)
          : binarySearch(nums, low, mid - 1, target);
      }
    }

    return -1;
  }
}
