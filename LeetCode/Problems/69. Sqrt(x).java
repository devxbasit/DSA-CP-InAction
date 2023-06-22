// https://leetcode.com/problems/sqrtx/
class Solution {

  public int mySqrt(int x) {
    if (x == 0 || x == 1) return x;

    // *** low = 1

    int low = 1;
    int high = x;

    int sqrt = 0;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      // mid * mid may result in overflow
      // mid * mid == x
      // divide above equation by mid both sides ==> mid = x / mid

      if (mid == x / mid) return mid;

      if (mid < x / mid) {
        sqrt = mid;
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return sqrt;
  }
}
