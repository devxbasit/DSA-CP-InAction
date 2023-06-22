import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

  public static int rodCutting(int profit[], int L) {
    // exact same as unbounded knapsack
    int dp[][] = new int[L + 1][L + 1];

    for (int size = 1; size < dp.length; size++) {
      for (int length = 1; length < dp[0].length; length++) {
        if (length < size) {
          dp[size][length] = dp[size - 1][length];
        } else {
          dp[size][length] =
            Math.max(
              profit[size - 1] + dp[size][length - size],
              dp[size - 1][length]
            );
        }
      }
    }

    return dp[dp.length - 1][dp[0].length - 1];
  }

  public static void main(String[] args) throws IOException {
    //code

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine().trim());

    while (T-- > 0) {
      int n = Integer.parseInt(br.readLine().trim());

      String S[] = br.readLine().trim().split(" ");

      int profit[] = new int[n];

      for (int i = 0; i < n; i++) {
        profit[i] = Integer.parseInt(S[i]);
      }

      System.out.println(rodCutting(profit, n));
    }
  }
}
