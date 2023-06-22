// https://leetcode.com/problems/reverse-bits/

public class Solution {

  // you need treat n as an unsigned value

  public int reverseBits(int n) {
    int sum = 0;

    int mask = 1;

    for (int pow = 31; pow >= 0; pow--) {
      sum = sum + ((n & mask) << pow);

      n >>= 1;
    }

    return sum;
  }
}
