// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class LuckyNumbers {

  public static void main(String args[]) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(read.readLine()); //testcases

    while (t-- > 0) {
      int n = Integer.parseInt(read.readLine()); //input n

      //printing "1" if isLucky() returns true else "0"
      System.out.println((new Solution().isLucky(n)) ? "1" : "0");
      new Solution().counter = 2;
    }
  }
}

// } Driver Code Ends

//User function Template for Java

class Solution {

  // Complete the function
  // n: Input n
  // counter: variable has already been declared in driver code
  //          you just have to use this variable.
  static int counter = 2;

  // Return True if the given number is a lucky number else return False
  public static boolean isLucky(int n) {
    // Your code here

    if (counter > n) return true;

    if (n % counter == 0) return false;

    n = n - n / counter;
    counter++;

    return isLucky(n);
  }
}
