// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class CheckIfTwoArraysAreEqual {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long t = sc.nextLong();

    while (t-- > 0) {
      int n = sc.nextInt();
      long a[] = new long[n];
      long b[] = new long[n];

      for (int i = 0; i < n; i++) {
        a[i] = sc.nextLong();
      }

      for (int i = 0; i < n; i++) {
        b[i] = sc.nextLong();
      }

      System.out.println(check(a, b, n) == true ? "1" : "0");
    }
  }

  // } Driver Code Ends

  //User function Template for Java

  public static boolean check(long arr[], long brr[], int n) {
    //Your code here
    // simple approach - sort both arrays and comapare

    HashMap<Long, Integer> hm = new HashMap<>();

    for (int i = 0; i < n; i++) {
      int count = 1;

      if (hm.get(arr[i]) != null) count = hm.get(arr[i]) + 1;

      hm.put(arr[i], count);
    }

    for (int i = 0; i < n; i++) {
      if (!hm.containsKey(brr[i])) return false;

      if (hm.get(brr[i]) == 0) return false;

      int count = hm.get(brr[i]);
      hm.put(brr[i], --count);
    }

    return true;
  }
  // { Driver Code Starts.

} // } Driver Code Ends
