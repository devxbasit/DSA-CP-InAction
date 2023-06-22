// https://leetcode.com/problems/kth-largest-element-in-an-array/
class Solution {

  void swap(int arr[], int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  void minHeapify(int arr[], int n, int i) {
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

  void maxHeapify(int arr[], int n, int i) {
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

  void buildMinHeap(int arr[], int n) {
    int lastNonLeafNodeIndex = ((n - 1) - 1) / 2;

    for (int i = lastNonLeafNodeIndex; i >= 0; i--) minHeapify(arr, n, i);
  }

  void buildMaxHeap(int arr[], int n) {
    int lastNonLeafNodeIndex = ((n - 1) - 1) / 2;

    for (int i = lastNonLeafNodeIndex; i >= 0; i--) maxHeapify(arr, n, i);
  }

  public int findKthLargest(int[] arr, int k) {
    // Your code here

    // via maxheap we have to pop k - 1 times root and maxHeapify

    // if k = 1, build max heap, return the root

    // via minheap we have to pop n - k times root and minHeapify

    int n = arr.length;

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

      for (int i = 0; i < k - 1; i++) {
        swap(arr, 0, n - 1);

        n--;

        maxHeapify(arr, n, 0);
      }
    }

    return arr[0];
  }
}
