/*package whatever //do not write package name here */

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

  public static void main(String[] args) {
    //Taking input using class Scanner
    Scanner in = new Scanner(System.in);

    //Taking count of testcases
    int t = in.nextInt();
    while (t-- > 0) {
      //takling count of elements
      int n = in.nextInt();

      //Creating an array of size n
      long arr[] = new long[n];

      //inserting elements to the array
      for (int i = 0; i < n; ++i) arr[i] = in.nextLong();

      //calling minCost method of class solve
      System.out.println(new solve().minCost(arr, n));
    }
  }
}

// } Driver Code Ends

class solve {

  long minCost(long arr[], int n) {
    // your code here

    Queue<Long> minHeap = new PriorityQueue<>();

    for (long i : arr) minHeap.add(i);

    long sum = 0;
    long temp;

    while (minHeap.size() > 1) {
      temp = minHeap.poll() + minHeap.poll();

      sum += temp;

      minHeap.add(temp);
    }

    return sum;
  }
}
