import java.io.*;
import java.util.*;

class CoinCombinationsI {

  public static int noOfWays(int coins[], int amount) {
    // f(x) = f(x - coin[i]) for each coin

    int dp[] = new int[amount + 1];

    dp[0] = 1;

    int MOD = 1000000007;

    for (int sum = 1; sum < dp.length; sum++) {
      for (int i = 0; i < coins.length; i++) {
        if (coins[i] > sum) continue;

        dp[sum] = (dp[sum] % MOD + dp[sum - coins[i]] % MOD) % MOD;
      }
    }

    return dp[dp.length - 1];
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String l1[] = br.readLine().trim().split(" ");
    String l2[] = br.readLine().trim().split(" ");

    int coins[] = new int[l2.length];

    for (int i = 0; i < coins.length; i++) coins[i] = Integer.parseInt(l2[i]);

    System.out.println(noOfWays(coins, Integer.parseInt(l1[1])));
  }
}
