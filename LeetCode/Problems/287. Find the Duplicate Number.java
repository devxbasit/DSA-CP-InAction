// https://leetcode.com/problems/find-the-duplicate-number/

class Solution {

  public int findDuplicate(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      int index = Math.abs(nums[i]) - 1;

      if (nums[index] < 0) return index + 1;

      nums[index] *= -1;
    }

    return -1;
  }
}
