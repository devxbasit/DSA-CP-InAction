// https://leetcode.com/problems/kth-largest-element-in-an-array/
class Solution {

  void swap(int arr[], int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  int partition(int arr[], int low, int high) {
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

  int quickSelect(int arr[], int low, int high, int k) {
    int pIndex = partition(arr, low, high);

    if (pIndex == k) return arr[pIndex];

    return pIndex > k
      ? quickSelect(arr, low, pIndex - 1, k)
      : quickSelect(arr, pIndex + 1, high, k);
  }

  public int findKthLargest(int[] nums, int k) {
    int n = nums.length;

    if (k > n) return -1;

    // kth largest element index = n - k
    return quickSelect(nums, 0, n - 1, n - k);
  }
}
