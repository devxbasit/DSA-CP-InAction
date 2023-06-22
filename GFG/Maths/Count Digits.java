class Solution {

  static int evenlyDivides(int N) {
    // https://practice.geeksforgeeks.org/problems/count-digits5716/1

    int num = N;
    int count = 0;

    while (num != 0) {
      int digit = num % 10;

      if (digit != 0 && N % digit == 0) count++;

      num = num / 10;
    }

    return count;
  }
}
