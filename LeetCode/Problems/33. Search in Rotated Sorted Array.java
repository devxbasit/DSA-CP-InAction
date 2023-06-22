// https://leetcode.com/problems/search-in-rotated-sorted-array/
class Solution {

  // https://www.youtube.com/watch?v=GU7DpgHINWQ&ab_channel=Errichto
  // https://www.youtube.com/watch?v=vF7gk4iaklA&ab_channel=Pepcoding

  // see also https://www.youtube.com/watch?v=Id-DdcWb5AU&t=144s&ab_channel=AdityaVerma

  public int binarySearch(int nums[], int target, int low, int high) {
    if (low > high) return -1;

    int mid = low + (high - low) / 2;

    if (nums[mid] == target) return mid;

    if (target > nums[mid]) {
      return binarySearch(nums, target, mid + 1, high);
    }

    return binarySearch(nums, target, low, mid - 1);
  }

  public int getPartitionIndex(int nums[]) {
    int low = 0;
    int high = nums.length - 1;

    // partition Index / boundry
    int PI = -1;

    // if mid element is greater that high, go right side
    // else save mid, and find other smaller on left side

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (nums[mid] > nums[high]) {
        low = mid + 1;
      } else {
        if (PI == -1) {
          PI = mid;
        } else {
          PI = nums[mid] < nums[PI] ? mid : PI;
        }

        high = mid - 1;
      }
    }

    return PI;
  }

  public int search(int[] nums, int target) {
    int PI = getPartitionIndex(nums);

    int left = Integer.MAX_VALUE;
    left = binarySearch(nums, target, 0, PI - 1);

    if (left != -1 && left != Integer.MAX_VALUE) return left;

    return binarySearch(nums, target, PI, nums.length - 1);
  }
}
