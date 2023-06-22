// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int tc = Integer.parseInt(br.readLine().trim());
    while (tc-- > 0) {
      String[] nx = br.readLine().trim().split(" ");
      int n = Integer.parseInt(nx[0]);
      int x = Integer.parseInt(nx[1]);
      String[] str = br.readLine().trim().split(" ");
      int[] a = new int[n];

      for (int i = 0; i < n; i++) a[i] = Integer.parseInt(str[i]);

      Solution sln = new Solution();
      if (sln.keypair(a, n, x) == true) System.out.println(
        "Yes"
      ); else System.out.println("No");
    }
  }
} // } Driver Code Ends

// User function Template for Java

class Solution {

  // A[] : the input array of positive integers
  // N : size of the array arr[]
  // X : the required sum
  public boolean keypair(int[] arr, int n, int x) {
    // code here

    HashSet<Integer> hs = new HashSet<>();

    for (int i = 0; i < n; i++) {
      if (arr[i] <= x) {
        if (hs.contains(x - arr[i])) return true;

        hs.add(arr[i]);
      }
    }
    return false;
  }
}
