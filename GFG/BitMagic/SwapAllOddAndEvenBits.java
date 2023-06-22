//Initial Template for Java

import java.io.*;
import java.util.*;

// } Driver Code Ends

//User function Template for Java

class Swap {

  // Function to swap odd and even bits
  public static int swapBits(int n) {
    // Your code

    // A = 1010, 5 = 0101

    int evenBits = (n & 0xAAAAAAAA);
    int oddBits = (n & 0x55555555);

    return ((evenBits >> 1) | (oddBits << 1));
  }
}

// { Driver Code Starts.

class SwapAllOddAndEvenBits {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt(); //testcases
    while (t-- > 0) {
      int n = sc.nextInt(); //taking n

      Swap obj = new Swap();

      //calling swapBits() method of class
      //Swap
      System.out.println(obj.swapBits(n));
    }
  }
} // } Driver Code Ends
