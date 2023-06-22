//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

// } Driver Code Ends

//User function Template for Java

class CountBitFlip {

  // Function to count number of bits to
  // be flipped to convert A to B
  public static int countBitsFlip(int a, int b) {
    // Your code here
    int diff = a ^ b;

    // count set bits

    int count = 0;

    while (diff != 0) {
      count++;
      diff = (diff & (diff - 1));
    }

    return count;
  }
}

// { Driver Code Starts.

// Driver class
class BitDifference {

  public static void main(String[] args)
    throws NumberFormatException, IOException {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt(); //testcases
    int m, n;
    long ans = 0; // initialise ans to 0
    while (t-- > 0) {
      //input m and n
      m = sc.nextInt();
      n = sc.nextInt();
      CountBitFlip obj = new CountBitFlip();
      System.out.println(obj.countBitsFlip(m, n));
    }
  }
}
// } Driver Code Ends
