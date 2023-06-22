import java.io.*;
import java.util.*;

class MinimizingCoins {

  public static int noOfWays(int coins[], int amount) {
    int dp[] = new int[amount + 1];

    dp[0] = 0;

    for (int i = 1; i < dp.length; i++) {
      dp[i] = Integer.MAX_VALUE;
    }

    for (int value = 1; value < dp.length; value++) {
      for (int i = 0; i < coins.length; i++) {
        if (coins[i] > value) continue;

        // we have to make sure that if we pick a coins,
        // then the remaining amount should have a valid min no of coins value
        // otherwise we will endup adding 1 to Int_MAX

        if (dp[value - coins[i]] == Integer.MAX_VALUE) continue;

        dp[value] = Math.min(dp[value], 1 + dp[value - coins[i]]);
      }
    }

    return (dp[dp.length - 1] == Integer.MAX_VALUE) ? -1 : dp[dp.length - 1];
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
