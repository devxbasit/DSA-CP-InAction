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

  static void minHeapify(int arr[], int n, int i) {
    int smallest = i;

    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < n && arr[left] < arr[smallest]) smallest = left;

    if (right < n && arr[right] < arr[smallest]) smallest = right;

    if (smallest != i) {
      swap(arr, i, smallest);

      minHeapify(arr, n, smallest);
    }
  }

  static void maxHeapify(int arr[], int n, int i) {
    int largest = i;

    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < n && arr[left] > arr[largest]) largest = left;

    if (right < n && arr[right] > arr[largest]) largest = right;

    if (largest != i) {
      swap(arr, i, largest);

      maxHeapify(arr, n, largest);
    }
  }

  static void buildMinHeap(int arr[], int n) {
    int lastNonLeafNodeIndex = ((n - 1) - 1) / 2;

    for (int i = lastNonLeafNodeIndex; i >= 0; i--) minHeapify(arr, n, i);
  }

  static void buildMaxHeap(int arr[], int n) {
    int lastNonLeafNodeIndex = ((n - 1) - 1) / 2;

    for (int i = lastNonLeafNodeIndex; i >= 0; i--) maxHeapify(arr, n, i);
  }

  public static int KthLargest(int arr[], int n, int k) {
    // Your code here

    // via maxheap we have to pop k - 1 times root and maxHeapify

    // if  k = 1, build max heap, return the root

    // via minheap we have to pop n - k times root and minHeapify

    if (n - k < k) {
      // using min heap

      buildMinHeap(arr, n);

      int nPops = n - k;

      for (int i = 0; i < nPops; i++) {
        swap(arr, 0, n - 1);
        n--;

        minHeapify(arr, n, 0);
      }
    } else {
      // using max heap

      buildMaxHeap(arr, n);

      // for (int i : arr)
      // System.out.print(i + " ");

      // return arr[0];

      for (int i = 0; i < k - 1; i++) {
        swap(arr, 0, n - 1);

        n--;

        maxHeapify(arr, n, 0);
      }
    }

    return arr[0];
  }
}
