// https://leetcode.com/problems/product-of-array-except-self/
class Solution {

  public int[] productExceptSelf(int[] nums) {
    // method 1
    // we have to solve it without division

    // int L[] = new int[nums.length];
    // int R[] = new int[nums.length];

    // L[0] = 1;

    // for (int i = 1; i < nums.length; i++) {

    // L[i] = nums[i - 1] * L[i - 1];

    // }

    // R[R.length - 1] = 1;

    // for (int i = nums.length - 2; i >= 0; i--) {

    // R[i] = nums[i + 1] * R[i + 1];

    // }

    // int answer[] = new int[nums.length];

    // for (int i = 0; i < answer.length; i++) {

    // answer[i] = L[i] * R[i];

    // }

    // return answer;

    // method 2 - same as above
    // we will be using the output array as one of L or R and
    // we will be constructing the other one on the fly.

    int L[] = new int[nums.length];
    L[0] = 1;

    for (int i = 1; i < nums.length; i++) {
      L[i] = nums[i - 1] * L[i - 1];
    }

    int R = 1;

    for (int i = nums.length - 2; i >= 0; i--) {
      R = R * nums[i + 1];
      L[i] = L[i] * R;
    }

    return L;
  }
}
