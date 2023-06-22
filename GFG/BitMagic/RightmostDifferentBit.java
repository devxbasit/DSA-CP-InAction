//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.BigInteger;
import java.util.*;

class RightmostDifferentBit {

  // } Driver Code Ends

  //User function Template for Java

  /*  function to find position of rightmost different bit
   *   m, n : Integers to find rightmost different bits
   *   You can have a look in the locked code for information
   *   regarding other functions including driver code
   */

  public static int getFirstSetBit(int n) {
    if (n == 0) return 0;

    int d = n ^ (n - 1);

    return (int) (Math.log(d) / Math.log(2)) + 1;
  }

  public static int posOfRightMostDiffBit(int m, int n) {
    // Your code here
    return getFirstSetBit(m ^ n);
  }

  // { Driver Code Starts.

  public static void main(String[] args)
    throws NumberFormatException, IOException {
    Scanner sc = new Scanner(System.in);

    //input number of testcases
    int t = sc.nextInt();
    int m, n;
    while (t-- > 0) {
      //input m and n
      m = sc.nextInt();
      n = sc.nextInt();
      System.out.println(posOfRightMostDiffBit(m, n));
    }
  }
}
// } Driver Code Ends
