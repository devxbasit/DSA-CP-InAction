// https://leetcode.com/problems/reverse-integer/
class Solution {

  public int reverse(int x) {
    // https://www.youtube.com/watch?v=1bfbV4jx0To&ab_channel=CodingwithConner

    int reversed = 0;
    int digit = 0;

    int maxLimit = Integer.MAX_VALUE / 10;
    int minLimit = Integer.MIN_VALUE / 10;

    while (x != 0) {
      digit = x % 10;
      x = x / 10;

      int temp = reversed;

      // see approach 1 - prevent overflow before hand

      // cause overflow and then check whether overflow has happened or not
      reversed = reversed * 10 + digit;

      if ((reversed - digit) / 10 != temp) return 0;
    }

    return reversed;
  }
}
