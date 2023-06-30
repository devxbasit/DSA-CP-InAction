// https://leetcode.com/problems/subarray-sum-equals-k/submissions/983082048/

// TC -> O(N + N) = O(2N) = O(N)
class Solution {

  public int subarraySum(int[] nums, int k) {
    int[] prefixSum = new int[nums.length];

    prefixSum[0] = nums[0];

    for (int i = 1; i < nums.length; i++) {
      prefixSum[i] += prefixSum[i - 1] + nums[i];
    }

    Map<Integer, Integer> map = new HashMap<>();

    map.put(0, 1);
    int subArrayCount = 0;

    for (int i = 0; i < prefixSum.length; i++) {
      if (map.containsKey(prefixSum[i] - k)) {
        subArrayCount += map.get(prefixSum[i] - k);
      }

      map.put(prefixSum[i], map.getOrDefault(prefixSum[i], 0) + 1);
    }

    return subArrayCount;
  }
}

// Approach 2  - one pass solution
// TC -> O(N) = O(N)

class Solution {

  public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);

    int subArrayCount = 0;
    int prefixSum = 0;

    for (int i = 0; i < nums.length; i++) {
      prefixSum += nums[i];

      if (map.containsKey(prefixSum - k)) {
        subArrayCount += map.get(prefixSum - k);
      }

      map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
    }

    return subArrayCount;
  }
}
