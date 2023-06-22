import java.io.*;
import java.lang.*;
import java.util.*;

class gfg {

  public static void main(String args[]) throws IOException {
    //reading input using BufferedReader class
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    //reading total testcases
    int t = Integer.parseInt(read.readLine());

    while (t-- > 0) {
      //reading number of elements and weight
      int n = Integer.parseInt(read.readLine());
      int w = Integer.parseInt(read.readLine());

      int val[] = new int[n];
      int wt[] = new int[n];

      String st[] = read.readLine().trim().split("\\s+");

      //inserting the values
      for (int i = 0; i < n; i++) val[i] = Integer.parseInt(st[i]);

      String s[] = read.readLine().trim().split("\\s+");

      //inserting the weigths
      for (int i = 0; i < n; i++) wt[i] = Integer.parseInt(s[i]);

      //calling method knapSack() of class Knapsack
      System.out.println(new Knapsack().knapSack(w, wt, val, n));
    }
  }
}

// } Driver Code Ends

class Knapsack {

  static int knapSackRecur(
    int wt[],
    int val[],
    int dp[][],
    int n,
    int capacity
  ) {
    if (n == 0 || capacity == 0) {
      return 0;
    }

    if (dp[n][capacity] != -1) {
      return dp[n][capacity];
    }

    if (wt[n - 1] > capacity) {
      return dp[n][capacity] = knapSackRecur(wt, val, dp, n - 1, capacity);
    }

    return (
      dp[n][capacity] =
        Math.max(
          val[n - 1] + knapSackRecur(wt, val, dp, n - 1, capacity - wt[n - 1]),
          knapSackRecur(wt, val, dp, n - 1, capacity)
        )
    );
  }

  // Returns the maximum value that can be put in a knapsack of capacity W

  static int knapSack(int W, int wt[], int val[], int n) {
    // your code here

    int dp[][] = new int[n + 1][W + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= W; j++) {
        dp[i][j] = -1;
      }
    }

    return knapSackRecur(wt, val, dp, n, W);
  }
}
