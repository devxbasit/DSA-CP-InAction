// https://leetcode.com/problems/increasing-triplet-subsequence/

class Solution {

  public boolean increasingTriplet(int[] nums) {
    int m = Integer.MAX_VALUE;
    int n = Integer.MAX_VALUE;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] <= m) {
        m = nums[i];
        continue;
      }

      if (nums[i] <= n) {
        n = nums[i];
        continue;
      }

      return true;
    }

    return false;
  }
}
