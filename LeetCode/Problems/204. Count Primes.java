// https://leetcode.com/problems/count-primes/
class Solution {

  public int countPrimes(int n) {
    // not n + 1, because we have to find primes less than n
    boolean dp[] = new boolean[n];

    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (dp[i] == true) continue;

      for (int j = i * i; j < n; j += i) {
        dp[j] = true;
      }
    }

    int count = 0;

    for (int i = 2; i < dp.length; i++) {
      if (dp[i] == false) {
        count++;
      }
    }

    return count;
  }
}
