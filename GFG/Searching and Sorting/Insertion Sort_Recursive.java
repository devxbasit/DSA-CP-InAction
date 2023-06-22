// https://practice.geeksforgeeks.org/problems/insertion-sort/1
class Solution {

  static void insert(int arr[], int i) {
    // Your code here
  }

  //Function to sort the array using insertion sort algorithm.
  public void insertionSort(int arr[], int n) {
    //code here

    if (n == 1) return;

    insertionSort(arr, n - 1);

    int num = arr[n - 1];
    int j = n - 2;

    while (j > -1 && arr[j] > num) {
      arr[j + 1] = arr[j];
      j--;
    }

    arr[j + 1] = num;
  }
}
