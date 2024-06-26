// { Driver Code Starts
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

  static int knapSack(int W, int wt[], int val[], int n) {
    // your code here

    int dp[][] = new int[n + 1][W + 1];

    for (int i = 0; i <= n; i++) {
      for (int w = 0; w <= W; w++) {
        if (i == 0 || w == 0) {
          dp[i][w] = 0;
        } else if (wt[i - 1] <= w) {
          dp[i][w] =
            Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
        } else {
          dp[i][w] = dp[i - 1][w];
        }
      }
    }

    return dp[n][W];
  }
}
