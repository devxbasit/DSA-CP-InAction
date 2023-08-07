// https://www.codingninjas.com/studio/problems/longest-subarray-with-sum-k_5713505

// TC -> O(N)
// SC -> O(N)

public class Solution {

  public static int getLongestSubarray(int[] nums, int k) {
    // Write your code here.

    int prefixSum = 0;
    int maxLen = 0;

    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);

    for (int i = 0; i < nums.length; i++) {
      prefixSum += nums[i];

      if (map.containsKey(prefixSum - k)) {
        maxLen = Math.max(maxLen, i - map.get(prefixSum - k));
      }

      if (!map.containsKey(prefixSum)) {
        map.put(prefixSum, i);
      }
    }

    return maxLen;
  }
}
