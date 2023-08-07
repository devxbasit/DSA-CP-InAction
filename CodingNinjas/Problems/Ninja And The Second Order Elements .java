// https://www.codingninjas.com/studio/problems/ninja-and-the-second-order-elements_6581960

public class Solution {

  public static int[] getSecondOrderElements(int n, int[] nums) {
    // Write your code here.

    int s1, s2, l1, l2;
    s1 = s2 = Integer.MAX_VALUE;
    l1 = l2 = Integer.MIN_VALUE;

    for (int i = 0; i < nums.length; i++) {
      // if in first go s1 is set to smallest element, s2 will remain INT_MAX
      if (nums[i] < s1) {
        s2 = s1;
        s1 = nums[i];
      } else if (nums[i] < s2) {
        s2 = nums[i];
      }

      if (nums[i] > l1) {
        l2 = l1;
        l1 = nums[i];
      } else if (nums[i] > l2) {
        l2 = nums[i];
      }
    }

    return new int[] { l2, s2 };
  }
}
