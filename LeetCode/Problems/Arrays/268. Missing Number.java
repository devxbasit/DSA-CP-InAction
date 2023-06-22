// https://leetcode.com/problems/missing-number/

class Solution {

  public int missingNumber(int[] nums) {
    Arrays.sort(nums);

    return binarySearch(nums, 0, nums.length - 1);
  }

  public int binarySearch(int[] nums, int low, int high) {
    if (low > high) return low;

    int mid = (high - low) / 2 + low;

    if (mid != 0 && nums[mid - 1] == mid - 1 && nums[mid] != mid) return mid;

    return (nums[mid] == mid)
      ? binarySearch(nums, mid + 1, high)
      : binarySearch(nums, low, mid - 1);
  }
}

// Approach 2 - sum of first n numbers formula
class Solution {

  public int missingNumber(int[] nums) {
    int n = nums.length;
    int sum = 0;
    for (int i = 0; i < nums.length; i++) sum += nums[i];

    return (n * (n + 1) / 2) - sum;
  }
}
