// https://www.codingninjas.com/studio/problems/number-of-inversions_6840276
// https://www.youtube.com/watch?v=AseUmwVNaoY

// TC -> O(NLogN)
public class Solution {

  public static int numberOfInversions(int[] nums, int n) {
    // Write your code here.

    return mergeSort(nums, 0, nums.length - 1);
  }

  public static int mergeSort(int[] nums, int low, int high) {
    int inverCount = 0;

    if (low < high) {
      int mid = low + (high - low) / 2;

      inverCount += mergeSort(nums, low, mid);
      inverCount += mergeSort(nums, mid + 1, high);
      inverCount += merge(nums, low, mid, high);
    }

    return inverCount;
  }

  public static int merge(int[] nums, int low, int mid, int high) {
    int[] sortedArray = new int[high - low + 1];
    int i = low, j = mid + 1, k = 0, inverCount = 0;

    while (i <= mid && j <= high) {
      if (nums[i] > nums[j]) {
        inverCount += mid - i + 1;
        sortedArray[k++] = nums[j++];
      } else {
        sortedArray[k++] = nums[i++];
      }
    }

    while (i <= mid) sortedArray[k++] = nums[i++];
    while (j <= high) sortedArray[k++] = nums[j++];

    for (int l = 0; l < sortedArray.length; l++) {
      nums[low + l] = sortedArray[l];
    }

    return inverCount;
  }
}
