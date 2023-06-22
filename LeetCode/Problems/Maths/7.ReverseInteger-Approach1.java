// https://leetcode.com/problems/reverse-integer/
class Solution {

  public int reverse(int x) {
    int reversed = 0;
    int digit = 0;

    int maxLimit = Integer.MAX_VALUE / 10;
    int minLimit = Integer.MIN_VALUE / 10;

    while (x != 0) {
      digit = x % 10;
      x = x / 10;

      // int range in java -2,147,483,648 to 2,147,483,647

      // detect overflow
      if (reversed > maxLimit || (reversed == maxLimit && digit > 7)) return 0;
      if (reversed < minLimit || (reversed == minLimit && digit > 8)) return 0;

      reversed = reversed * 10 + digit;
    }

    return reversed;
  }
}
