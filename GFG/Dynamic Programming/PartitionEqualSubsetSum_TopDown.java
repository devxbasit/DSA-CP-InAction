// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {

  public static void main(String args[]) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(in.readLine());
    while (t-- > 0) {
      int N = Integer.parseInt(in.readLine());
      String input_line[] = in.readLine().trim().split("\\s+");
      int arr[] = new int[N];
      for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);

      Solution ob = new Solution();
      int x = ob.equalPartition(N, arr);
      if (x == 1) System.out.println("YES"); else System.out.println("NO");
    }
  }
} // } Driver Code Ends

// User function Template for Java

class Solution {

  static boolean subset(int nums[], int sum) {
    boolean dp[][] = new boolean[nums.length + 1][sum + 1];

    for (int i = 1; i < dp[0].length; i++) {
      dp[0][i] = false;
    }

    for (int i = 0; i < dp.length; i++) {
      dp[i][0] = true;
    }

    for (int n = 1; n < dp.length; n++) {
      for (int value = 1; value < dp[0].length; value++) {
        if (nums[n - 1] > value) {
          dp[n][value] = dp[n - 1][value];
        } else {
          dp[n][value] = dp[n - 1][value - nums[n - 1]] || dp[n - 1][value];
        }
      }
    }

    return dp[dp.length - 1][dp[0].length - 1];
  }

  static int equalPartition(int N, int nums[]) {
    // code here

    int sum = 0;

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }

    if (sum % 2 != 0) {
      return 0;
    }

    return subset(nums, sum / 2) == true ? 1 : 0;
  }
}
