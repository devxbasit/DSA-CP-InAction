// leetcode premium question
// https://leetcode.com/problems/missing-ranges/
// https://www.lintcode.com/problem/641/

public class Solution {
  /*
   * @param nums: a sorted integer array
   * 
   * @param lower: An integer
   * 
   * @param upper: An integer
   * 
   * @return: a list of its missing ranges
   */

  public int binarySearch(int nums[], int target) {

    int low = 0;
    int high = nums.length - 1;

    int res = -1;

    while (low <= high) {

      int mid = low + (high - low) / 2;

      if (nums[mid] >= target)
        res = mid;

      if (nums[mid] >= target) {

        res = mid;
        high = mid - 1;

      } else {

        low = mid + 1;

      }

    }

    return res;

  }

  public List<String> findMissingRanges(int[] nums, int lower, int upper) {

    // write your code here

    List<String> al = new ArrayList<>();

    Arrays.sort(nums);

    int i = binarySearch(nums, lower);

    if (nums.length == 0 || i == -1) {

      if (lower == upper) {

        al.add(Integer.toString(lower));
        return al;

      }

      al.add(Integer.toString(lower) + "->" + Integer.toString(upper));
      return al;

    }

    int prev = lower;

    if (nums[i] > lower) {
      int x = lower;
      int y = nums[i] - 1;

      if (x == y) {

        al.add(Integer.toString(x));

      } else if (x < y) {

        al.add(Integer.toString(x) + "->" + Integer.toString(y));

      }

      prev = nums[i];
      i++;

    } else {

      i++;

    }

    while (i < nums.length && nums[i] <= upper) {

      if (i > 0 && nums[i] == nums[i - 1]) {

        i++;
        continue;

      }

      int x = prev + 1;
      int y = nums[i] - 1;

      if (x == y) {

        al.add(Integer.toString(x));

      } else if (x < y) {

        al.add(Integer.toString(x) + "->" + Integer.toString(y));

      }

      prev = nums[i];
      i++;

    }

    i--;

    if (nums[i] < upper) {

      int x = nums[i] + 1;
      int y = upper;

      if (x == y) {

        al.add(Integer.toString(x));

      } else if (x < y) {

        al.add(Integer.toString(x) + "->" + Integer.toString(y));

      }
    }

    return al;
  }
}