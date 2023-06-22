// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Array {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();

    for (int i = 0; i < t; i++) {
      int n = sc.nextInt();
      int s = sc.nextInt();

      int[] m = new int[n];
      for (int j = 0; j < n; j++) {
        m[j] = sc.nextInt();
      }

      Subarray obj = new Subarray();
      ArrayList<Integer> res = obj.subarraySum(n, s, m);
      for (int ii = 0; ii < res.size(); ii++) System.out.print(
        res.get(ii) + " "
      );
      System.out.println();
    }
  }
} // } Driver Code Ends

class Subarray {

  static ArrayList<Integer> subarraySum(int n, int s, int[] m) {
    // Your code here
    ArrayList<Integer> AL = new ArrayList<>();

    int currentSum = 0;
    int left = 0;
    int right = 0;

    for (int i = 0; i <= n; i++) {
      while (currentSum > s) currentSum -= m[left++];

      if (currentSum == s) {
        AL.add(left + 1);
        AL.add(right);
        return AL;
      }

      if (i < n) currentSum += m[right++];
    }

    AL.add(-1);
    return AL;
  }
}
