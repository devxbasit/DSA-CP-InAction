// https://leetcode.com/problems/contains-duplicate-ii/
class Solution {

  public boolean containsNearbyDuplicate(int[] nums, int k) {
    HashSet<Integer> hs = new HashSet<>();

    int n = nums.length;

    for (int i = 0; i < n; i++) {
      if (hs.contains(nums[i])) return true;

      hs.add(nums[i]);

      if (i >= k) hs.remove(nums[i - k]);
    }

    return false;
  }
}
