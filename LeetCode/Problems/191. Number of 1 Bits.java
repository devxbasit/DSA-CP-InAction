// https://leetcode.com/problems/number-of-1-bits/
public class Solution {

  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
    int count = 0;

    while (n != 0) {
      count++;

      n = n & (n - 1);
    }

    return count;
    // method 2 - but not efficient than above
    // int count = 0;
    // int mask = 1;

    // for (int i = 0; i < 32; i++) {

    // if ((n & mask) != 0) count++;

    // mask <<= 1;

    // }

    // return count;

  }
}
