//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {

  public static void main(String[] args) {
    //taking input using Scanner class
    Scanner sc = new Scanner(System.in);

    //taking total count of testcases
    int testcases = sc.nextInt();
    while (testcases-- > 0) {
      //taking value
      int value = sc.nextInt();

      //taking number of coins
      int numberOfCoins = sc.nextInt();
      int coins[] = new int[numberOfCoins];

      //inserting coins to the array
      for (int i = 0; i < numberOfCoins; i++) {
        int x = sc.nextInt();
        coins[i] = x;
      }

      //creating an object of class Geeks
      Geeks obj = new Geeks();

      //calling method numberOfWays() of class Geeks
      System.out.println(obj.numberOfWays(coins, numberOfCoins, value));
    }
  }
}

// } Driver Code Ends

//User function Template for Java

class Geeks {

  int recur(int coins[], int dp[][], int n, int sum) {
    if (sum == 0) {
      return 1;
    } else if (n == 0) {
      return 0;
    }

    if (dp[n][sum] != -1) {
      return dp[n][sum];
    }

    if (sum - coins[n - 1] < 0) {
      return dp[n][sum] = recur(coins, dp, n - 1, sum);
    }

    return (
      dp[n][sum] =
        recur(coins, dp, n, sum - coins[n - 1]) + recur(coins, dp, n - 1, sum)
    );
  }

  //Complete this function
  public long numberOfWays(int coins[], int numberOfCoins, int value) {
    int dp[][] = new int[numberOfCoins + 1][value + 1];

    for (int i = 0; i <= numberOfCoins; i++) {
      for (int j = 0; j <= value; j++) {
        dp[i][j] = -1;
      }
    }

    return recur(coins, dp, numberOfCoins, value);
  }
}
// { Driver Code Starts.
// } Driver Code Ends
