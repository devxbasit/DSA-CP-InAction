import java.io.*;
import java.util.*;

public class PairSum {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine().trim());
    while (tc-- > 0) {
      String[] inputLine;
      inputLine = br.readLine().trim().split(" ");
      int n = Integer.parseInt(inputLine[0]);
      int x = Integer.parseInt(inputLine[1]);
      int[] arr = new int[n];
      inputLine = br.readLine().trim().split(" ");
      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(inputLine[i]);
      }

      boolean ans = new Solution().hasArrayTwoCandidates(arr, n, x);
      System.out.println(ans ? "Yes" : "No");
    }
  }
}

// } Driver Code Ends

//User function Template for Java

class Solution {

  boolean hasArrayTwoCandidates(int arr[], int n, int x) {
    // code here
    Arrays.sort(arr);

    int low = 0;
    int high = n - 1;
    int sum = 0;

    while (low < high) {
      sum = arr[low] + arr[high];

      if (sum == x) return true;

      if (sum < x) low++; else high--;
    }
    return false;
  }
}
