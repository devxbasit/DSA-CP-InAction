// https://leetcode.com/problems/power-of-three/
class Solution {

  public boolean isPowerOfThree(int n) {
    // The logic is very simple. Any integer number other than power of 3 which
    // divides highest power of 3 value that integer can hold 3^19 = 1162261467
    // (Assuming that integers are stored using 32 bits) will give reminder
    // non-zero.

    if (n < 1) return false;

    return Math.pow(3, 19) % n == 0;
    /*
     * method 2
     *
     * if (n < 1) {
     * return false;
     * }
     *
     * while (n % 3 == 0) {
     * n /= 3;
     * }
     *
     * return n == 1;
     *
     */

  }
}
