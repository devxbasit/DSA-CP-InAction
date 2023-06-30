// https://leetcode.com/problems/rearrange-array-elements-by-sign/description/
class Solution {

  public int[] rearrangeArray(int[] nums) {
    int[] res = new int[nums.length];

    int nextEvenIndex = 0;
    int nextOddIndex = 1;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < 0) {
        res[nextOddIndex] = nums[i];
        nextOddIndex += 2;
      } else {
        res[nextEvenIndex] = nums[i];
        nextEvenIndex += 2;
      }
    }

    return res;
  }
}
