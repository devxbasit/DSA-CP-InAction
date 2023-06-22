//{ Driver Code Starts
import java.util.*;

// https://practice.geeksforgeeks.org/problems/selection-sort/1
class GFG {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t > 0) {
      int n = sc.nextInt();
      int arr[] = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }

      Solution obj = new Solution();
      obj.selectionSort(arr, n);

      for (int i = 0; i < n; i++) System.out.print(arr[i] + " ");
      System.out.println();
      t--;
    }
  }
}

// } Driver Code Ends

class Solution {

  int select(int arr[], int i) {
    // code here such that selectionSort() sorts arr[]

    int minIndex = i;

    i++;

    for (; i < arr.length; i++) {
      if (arr[i] < arr[minIndex]) {
        minIndex = i;
      }
    }

    return minIndex;
  }

  void selectionSort(int arr[], int n) {
    // code here

    if (n == 1) return;

    for (int i = 0; i < arr.length - 1; i++) {
      swap(arr, i, select(arr, i));
    }
  }

  public void swap(int arr[], int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
