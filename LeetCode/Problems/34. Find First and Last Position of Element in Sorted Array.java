// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
class Solution {

  class Pair {

    int i;
    int j;

    Pair() {
      i = -1;
      j = -1;
    }
  }

  void binarySearch(int nums[], int target, Pair p, int low, int high) {
    if (low > high) return;

    int mid = low + (high - low) / 2;

    if (nums[mid] == target) {
      // if not yet found
      if (p.i == -1) {
        if (mid == 0 || nums[mid - 1] < target) {
          p.i = mid;
        } else {
          // recur on left side
          binarySearch(nums, target, p, low, mid - 1);
        }
      }

      // if not yet found
      if (p.j == -1) {
        if (mid == nums.length - 1 || nums[mid + 1] > target) {
          p.j = mid;
        } else {
          // recur on right side
          binarySearch(nums, target, p, mid + 1, high);
        }
      }
    } else if (nums[mid] > target) {
      binarySearch(nums, target, p, low, mid - 1);
    } else {
      binarySearch(nums, target, p, mid + 1, high);
    }
  }

  public int[] searchRange(int[] nums, int target) {
    Pair p = new Pair();

    binarySearch(nums, target, p, 0, nums.length - 1);

    int res[] = new int[2];

    res[0] = p.i;
    res[1] = p.j;

    return res;
  }
}
