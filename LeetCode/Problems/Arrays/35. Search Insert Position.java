// https://leetcode.com/problems/search-insert-position/description/
class Solution {

  public int searchInsert(int[] nums, int target) {
    if (target <= nums[0]) return 0;
    if (target == nums[nums.length - 1]) return nums.length - 1;
    if (target > nums[nums.length - 1]) return nums.length;

    return binarySearch(nums, 0, nums.length - 1, target);
  }

  public int binarySearch(int[] nums, int low, int high, int target) {
    if (low <= high) {
      int mid = low + (high - low) / 2;

      if (
        (mid == 0 || nums[mid - 1] < target) && !(nums[mid] < target)
      ) return mid;

      if (nums[mid] < target) {
        return binarySearch(nums, mid + 1, high, target);
      } else {
        return binarySearch(nums, low, mid - 1, target);
      }
    }

    return -1;
  }
}
