// https://leetcode.com/problems/single-number/

// Approach 1
class Solution {

  public int singleNumber(int[] nums) {
    int res = 0;

    for (int i = 0; i < nums.length; i++) {
      res ^= nums[i];
    }

    return res;
  }
}

// Approach 2
class Solution {

  public int singleNumber(int[] nums) {
    HashSet<Integer> hs = new HashSet<>();

    int arrSum = 0;
    int uniqueElementSum = 0;

    for (int n : nums) {
      arrSum += n;

      if (!hs.contains(n)) {
        hs.add(n);
        uniqueElementSum += n;
      }
    }

    return uniqueElementSum * 2 - arrSum;
  }
}
// approach - frequency count
// approach - sort first array, and traverse
