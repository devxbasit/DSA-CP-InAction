// https://practice.geeksforgeeks.org/problems/insertion-sort/1

// TC -> O(N^2)
class Solution {

  static void insert(int nums[], int i) {
    int temp = nums[i];
    i--;

    while (i > -1 && temp < nums[i]) {
      nums[i + 1] = nums[i];
      i--;
    }

    nums[i + 1] = temp;
  }

  public void insertionSort(int nums[], int n) {
    for (int i = 1; i < nums.length; i++) {
      insert(nums, i);
    }
  }

  public void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
