// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {

  public static void main(String[] args) {
    //Taking input using class Scanner
    Scanner sc = new Scanner(System.in);

    //Taking total count of testcases
    int t = sc.nextInt();

    while (t-- > 0) {
      //taking total count of elements
      int n = sc.nextInt();

      //creating a new array of size n
      int arr[] = new int[n];

      //inserting elements to the array
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }

      //calling firstRepeated method
      //and printing the result
      System.out.println(firstRepeated(arr, n));
    }
  }

  // } Driver Code Ends

  //User function Template for Java

  public static int firstRepeated(int[] arr, int n) {
    //Your code here
    HashSet<Integer> hs = new HashSet<>();

    int index = -1;
    for (int i = n - 1; i >= 0; i--) if (hs.contains(arr[i])) index =
      i; else hs.add(arr[i]);

    return (index == -1) ? index : index + 1;
  }
  // { Driver Code Starts.

} // } Driver Code Ends
