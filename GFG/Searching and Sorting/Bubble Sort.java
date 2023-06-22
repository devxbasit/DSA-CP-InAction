// https://practice.geeksforgeeks.org/problems/bubble-sort/1

class Solution {

  // Function to sort the array using bubble sort algorithm.
  public static void bubbleSort(int arr[], int n) {
    // code here

    boolean swapFlag = false;

    for (int i = 0; i < n - 1; i++) {
      swapFlag = false;

      for (int j = 0; j < n - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          swap(arr, j, j + 1);
          swapFlag = true;
        }
      }

      if (swapFlag == false) return;
    }
  }

  public static void swap(int arr[], int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
