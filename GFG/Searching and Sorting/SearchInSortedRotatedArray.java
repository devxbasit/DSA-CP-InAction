//Initial Template for Java

import java.io.*;
import java.util.*;

public class SearchInSortedRotatedArray {

  public static void main(String args[]) throws IOException {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while (t > 0) {
      int n = sc.nextInt();
      int[] array = new int[n];
      for (int i = 0; i < n; i++) {
        array[i] = sc.nextInt();
      }
      int target = sc.nextInt();

      Solution ob = new Solution();
      System.out.println(ob.Search(array, target));
      t--;
    }
  }
} // } Driver Code Ends

//User function Template for Java

class Solution {

  public static int findIndex(int arr[], int low, int high, int target) {
    if (low <= high) {
      int mid = low + (high - low) / 2;

      if (arr[mid] == target) return mid;

      if (arr[low] < arr[mid]) {
        if (target >= arr[low] && target < arr[mid]) return findIndex(
          arr,
          low,
          mid - 1,
          target
        ); else return findIndex(arr, mid + 1, high, target);
      } else {
        if (target > arr[mid] && target <= arr[high]) return findIndex(
          arr,
          mid + 1,
          high,
          target
        ); else return findIndex(arr, low, mid - 1, target);
      }
    }
    return -1;
  }

  static int Search(int array[], int target) {
    // code here
    return findIndex(array, 0, array.length - 1, target);
  }
}
