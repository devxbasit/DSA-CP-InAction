import java.io.*;
import java.util.*;

class DiceCombinations {

  public static int noOfWays(int n) {
    if (n < 0) return 0;
    if (n == 0 || n == 1) return 1;

    int dp[] = new int[n + 1];
    int M = 1000000007;

    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i < dp.length; i++) {
      for (int j = 1; j <= 6; j++) {
        if (j > i) break;

        dp[i] = (dp[i] % M + dp[i - j] % M) % M;
      }
    }

    return dp[dp.length - 1];
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int sum = Integer.parseInt(br.readLine().trim());

    System.out.println(noOfWays(sum));
  }
}
