// https://leetcode.com/problems/next-permutation/
// https://www.youtube.com/watch?v=JDOXKqF60RQ

class Solution {

  public void nextPermutation(int[] nums) {
    for (int i = nums.length - 2; i > -1; i--) {
      if (nums[i] < nums[i + 1]) {
        swap(
          nums,
          i,
          getClosestMaxElementIndex(nums, i + 1, nums.length - 1, nums[i])
        );
        reverse(nums, i + 1, nums.length - 1);
        return;
      }
    }

    reverse(nums, 0, nums.length - 1);
  }

  public int getClosestMaxElementIndex(
    int[] nums,
    int low,
    int high,
    int element
  ) {
    int currMaxElement = Integer.MAX_VALUE;
    int currMaxElementIndex = -1;

    for (; low <= high; low++) {
      if (nums[low] > element && nums[low] <= currMaxElement) {
        currMaxElement = nums[low];
        currMaxElementIndex = low;
      }
    }

    return currMaxElementIndex;
  }

  public void reverse(int[] nums, int low, int high) {
    while (low < high) {
      int temp = nums[low];
      nums[low] = nums[high];
      nums[high] = temp;

      low++;
      high--;
    }
  }

  public void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
