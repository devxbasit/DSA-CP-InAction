import java.io.*;
import java.util.*;

class GFG {

  public static void main(String[] args) {
    //taking input using Scanner class
    Scanner sc = new Scanner(System.in);

    //taking count of testcases
    int t = sc.nextInt();
    while (t-- > 0) {
      //taking count of houses
      int n = sc.nextInt();
      int arr[] = new int[n];

      //inserting money present in
      //each house in the array
      for (int i = 0; i < n; ++i) arr[i] = sc.nextInt();

      //calling method FindMaxSum() of class solve
      System.out.println(new solve().FindMaxSum(arr, n));
    }
  }
} // } Driver Code Ends

class solve {

  // Function to return maximum of sum without adjacent elements
  public int FindMaxSum(int arr[], int n) {
    // Your code here

    if (n == 0) {
      return 0;
    } else if (n == 1) {
      return arr[0];
    } else if (n == 2) {
      return Math.max(arr[0], arr[1]);
    }

    int dp[] = new int[n];

    dp[0] = arr[0];

    dp[1] = Math.max(arr[0], arr[1]);

    for (int i = 2; i < n; i++) {
      dp[i] = Math.max(arr[i] + dp[i - 2], dp[i - 1]);
    }

    return dp[n - 1];
  }
}
