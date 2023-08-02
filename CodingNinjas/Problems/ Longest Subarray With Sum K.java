// https://www.codingninjas.com/studio/problems/longest-subarray-with-sum-k_6682399

// TC ->  O(N)
// SC -> O(N)
import java.lang.Math;
import java.util.*;

public class Solution {

  public static int longestSubarrayWithSumK(int[] nums, long k) {
    int prefixSum = 0;
    int maxSubArrLen = 0;

    HashMap<Integer, Integer> map = new HashMap<>();

    map.put(0, -1);

    for (int i = 0; i < nums.length; i++) {
      prefixSum += nums[i];

      if (map.containsKey(prefixSum - (int) k)) {
        maxSubArrLen = Math.max(maxSubArrLen, i - map.get(prefixSum - (int) k));
      }

      if (!map.containsKey(prefixSum)) {
        map.put(prefixSum, i);
      }
    }

    return maxSubArrLen;
  }
}
