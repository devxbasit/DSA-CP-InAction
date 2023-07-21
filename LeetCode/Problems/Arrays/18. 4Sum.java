// https://leetcode.com/problems/4sum/description/
// TC -> O(N^3)

class Solution {

  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> resultList = new ArrayList<>();

    // fix 2 pointer, and then 2 sum

    for (int i = 0; i < nums.length - 3; i++) {
      while (i != 0 && i < nums.length - 3 && nums[i] == nums[i - 1]) i++;

      for (int j = i + 1; j < nums.length - 2; j++) {
        while (j != i + 1 && j < nums.length - 2 && nums[j] == nums[j - 1]) j++;

        int k = j + 1;
        int l = nums.length - 1;

        while (k < l) {
          long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

          if (sum == (long) target) {
            resultList.add(
              new ArrayList(Arrays.asList(nums[i], nums[j], nums[k], nums[l]))
            );

            while (k < l && nums[l] == nums[l - 1]) {
              l--;
            }

            l--;
          } else if (sum < (long) target) {
            k++;
          } else {
            l--;
          }
        }
      }
    }

    return resultList;
  }
}
