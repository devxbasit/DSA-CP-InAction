// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int A[] = new int[n];
      for (int i = 0; i < n; i++) A[i] = sc.nextInt();
      Solution ob = new Solution();
      System.out.println(ob.minDiffernce(A, n));
    }
  }
} // } Driver Code Ends

//User function Template for Java

class Solution {

  public int minDiffernce(int arr[], int size) {
    // Your code goes here

    // https://www.youtube.com/watch?v=WJUXGJ4pGtM&ab_channel=CodingSimplified
    // https://www.youtube.com/watch?v=_gPcYovP7wc&t=1263s&ab_channel=AdityaVerma

    int S = 0;

    for (int i = 0; i < arr.length; i++) S += arr[i];

    boolean dp[][] = new boolean[size + 1][(S / 2) + 1];

    for (int i = 0; i < dp.length; i++) dp[i][0] = true;
    for (int j = 1; j < dp[0].length; j++) dp[0][1] = false;

    for (int n = 1; n < dp.length; n++) {
      for (int sum = 1; sum < dp[0].length; sum++) {
        if (arr[n - 1] > sum) {
          dp[n][sum] = dp[n - 1][sum];
        } else {
          dp[n][sum] = dp[n - 1][sum - arr[n - 1]] || dp[n - 1][sum];
        }
      }
    }

    for (int s1 = dp[0].length - 1; s1 >= 0; s1--) {
      if (dp[dp.length - 1][s1]) {
        return Math.abs(S - 2 * s1);
      }
    }

    return -1;
  }
}
