/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {

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
    long key;
    int freq;

    for (int i = 0; i < n; i++) {
      freq = 1;
      key = arr[i];

      if (hm.containsKey(key)) freq = hm.get(key) + 1;

      hm.put(key, freq);
    }

    for (int i = 0; i < n; i++) {
      key = brr[i];

      if (!hm.containsKey(key)) return false;

      freq = hm.get(key) - 1;

      if (freq == 0) hm.remove(key); else hm.put(key, freq);
    }

    return true;
  }
  // { Driver Code Starts.

} // } Driver Code Ends
