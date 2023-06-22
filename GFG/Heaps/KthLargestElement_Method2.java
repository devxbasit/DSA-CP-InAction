// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class gfg {

  public static void main(String args[]) {
    //taking input using class Scanner
    Scanner sc = new Scanner(System.in);

    //taking count of testcases
    int t = sc.nextInt();

    while (t-- > 0) {
      //taking count of elements
      int n = sc.nextInt();

      //taking the value of k
      int k = sc.nextInt();

      //Creating an array of size n
      int arr[] = new int[n];

      //adding all the elements to arr
      for (int i = 0; i < n; ++i) arr[i] = sc.nextInt();

      //calling the method KthLargest of class solve
      //and printing the result
      System.out.println(new solve().KthLargest(arr, n, k));
    }
  }
} // } Driver Code Ends

class solve {

  static void swap(int arr[], int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  static int partition(int arr[], int low, int high) {
    int pivot = arr[high];

    int i = low - 1, j = low;

    for (; j < high; j++) {
      if (arr[j] <= pivot) {
        swap(arr, ++i, j);
      }
    }

    swap(arr, ++i, high);
    return i;
  }

  static int quickSelect(int arr[], int low, int high, int k) {
    int pIndex = partition(arr, low, high);

    if (pIndex == k) return arr[pIndex];

    // if partition index > k, recur on left side, else right side
    return pIndex > k
      ? quickSelect(arr, low, pIndex - 1, k)
      : quickSelect(arr, pIndex + 1, high, k);
  }

  public static int KthLargest(int arr[], int n, int k) {
    // Your code here

    if (k > n) return -1;

    // kth largest element index = n - k
    return quickSelect(arr, 0, n - 1, n - k);
  }
}
