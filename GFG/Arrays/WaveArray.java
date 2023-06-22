// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases

    while (t-- > 0) {
      int n = Integer.parseInt(br.readLine().trim()); // taking size of array
      int arr[] = new int[n]; // declaring array of size n
      String inputLine[] = br.readLine().trim().split(" ");
      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
      }

      Solution obj = new Solution();

      obj.convertToWave(arr, n);

      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < n; i++) sb.append(arr[i] + " ");

      System.out.println(sb); // print array
    }
  }
}

// } Driver Code Ends
class Solution {

  // arr: input array
  // n: size of the array
  //Function to sort the array into a wave-like array.

  public static void swap(int arr[], int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void convertToWave(int arr[], int n) {
    // Your code here
    //method 1 - this method works even when array is not sorted

    // TBD - solve wiggle sort 2, on leetcode
    for (int i = 0; i < arr.length; i = i + 2) {
      if (i > 0 && arr[i] < arr[i - 1]) swap(arr, i, i - 1);

      if (i < arr.length - 1 && arr[i] < arr[i + 1]) swap(arr, i, i + 1);
    }
    //method 2
    // for (int i = 0; i < arr.length - 1; i = i + 2) {

    //     swap(arr, i, i + 1);

    // }

  }
}
// { Driver Code Starts.
// } Driver Code Ends
