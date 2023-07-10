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

// Approach 2  - https://www.youtube.com/watch?v=DhFh8Kw7ymk
// SC -> O(3 * K) , k is the number of triplets
// TC -> O(N * N) = O(N^2)
class Solution {

  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);

    List<List<Integer>> resultList = new ArrayList<>();

    for (int i = 0; i < nums.length - 2; i++) {
      while (i != 0 && i < nums.length - 2 && nums[i] == nums[i - 1]) {
        i++;
      }

      int x = nums[i];
      int target = -x;
      int j = i + 1;
      int k = nums.length - 1;

      while (j < k) {
        if (nums[j] + nums[k] == target) {
          resultList.add(Arrays.asList(nums[i], nums[j], nums[k]));

          while (j < k && nums[k] == nums[k - 1]) {
            k--;
          }

          k--;
        } else if (nums[j] + nums[k] < target) {
          j++;
        } else {
          k--;
        }
      }
    }

    return resultList;
  }
}
