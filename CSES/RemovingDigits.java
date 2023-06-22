import java.io.*;
import java.util.*;

class RemovingDigits {

  public static int noOfSteps(int n) {
    if (n == 0) return 0;
    if (n < 10) return 1;

    int dp[] = new int[n + 1];

    dp[0] = 0;

    for (int i = 1; i < dp.length; i++) {
      dp[i] = Integer.MAX_VALUE;
    }

    for (int i = 1; i < dp.length; i++) {
      int num = i;

      while (num > 0) {
        int digit = num % 10;
        num /= 10;

        if (digit > i || digit == 0) continue;

        if (dp[i - digit] == Integer.MAX_VALUE) continue;

        dp[i] = Math.min(dp[i], 1 + dp[i - digit]);
      }
    }

    return dp[dp.length - 1];
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine().trim());

    System.out.println(noOfSteps(n));
  }
}
