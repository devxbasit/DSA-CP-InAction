// https://leetcode.com/problems/3sum/
class Solution {

  void twoSum(int nums[], int low, List<List<Integer>> al, int x) {
    int target = -x;

    int high = nums.length - 1;

    int i = low;
    int j = high;

    while (i < j) {
      // skip duplicates
      if (i != low && nums[i] == nums[i - 1]) {
        i++;
        continue;
      }

      // skip duplicates
      if (j != high && nums[j] == nums[j + 1]) {
        j--;
        continue;
      }

      if (nums[i] + nums[j] == target) {
        List<Integer> temp = new ArrayList<>();

        temp.add(x);
        temp.add(nums[i]);
        temp.add(nums[j]);

        al.add(temp);
        i++;
        continue;
      }

      if (nums[i] + nums[j] > target) {
        j--;
      } else {
        i++;
      }
    }
  }

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> al = new ArrayList<>();

    Arrays.sort(nums);

    // select one, and find rest 2 using 2Sum

    for (int i = 0; i < nums.length - 2; i++) {
      // skip over duplicates
      if (i != 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      twoSum(nums, i + 1, al, nums[i]);
    }

    return al;
  }
}
