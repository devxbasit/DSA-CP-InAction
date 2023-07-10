//https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1

// TC -> O(N)
// SC -> O(N)

class GfG {

  int maxLen(int nums[], int n) {
    // Your code here

    int[] prefixSum = new int[nums.length];

    prefixSum[0] = nums[0];

    for (int i = 1; i < prefixSum.length; i++) {
      prefixSum[i] = prefixSum[i - 1] + nums[i];
    }

    int maxSubArrayLength = 0;
    Map<Integer, Integer> map = new HashMap<>();

    map.put(0, -1);

    for (int i = 0; i < prefixSum.length; i++) {
      if (map.containsKey(prefixSum[i])) {
        maxSubArrayLength =
          Math.max(maxSubArrayLength, i - map.get(prefixSum[i]));
      } else {
        map.put(prefixSum[i], i);
      }
    }

    return maxSubArrayLength;
  }
}
