//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class SumOfDigitsOfANumber {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt(); //taking testcases

    while (t-- > 0) {
      int n = sc.nextInt(); // taking number "n" as input
      System.out.println(new Digitsum().sumOfDigits(n)); // computing sum of digits of n
    }
  }
}

// } Driver Code Ends

//User function Template for Java

class Digitsum {

  // complete the function
  public static int sumOfDigits(int n) {
    // add your code here

    return (n == 0) ? 0 : n % 10 + sumOfDigits(n / 10);
  }
}
