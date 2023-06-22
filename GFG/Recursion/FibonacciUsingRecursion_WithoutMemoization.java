//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class FibonacciUsingRecursion_WithoutMemoization {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt(); //taking total testcases

    while (t-- > 0) {
      int n = sc.nextInt(); // taking n as input
      System.out.println(new PrintFib().fibonacci(n)); // print the nth fibonacci number
    }
  }
}

// } Driver Code Ends

//User function Template for Java

class PrintFib {

  static long fib;

  static long fibonacci(int n) {
    // your code here

    if (n == 0) return 0;

    if (n == 1) return 1;

    return fib = fibonacci(n - 1) + fibonacci(n - 2);
  }
}
