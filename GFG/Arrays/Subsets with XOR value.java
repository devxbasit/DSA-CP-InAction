// https://www.interviewbit.com/problems/subarray-with-given-xor/

public class Solution {

  public int solve(int[] nums, int K) {
    int[] prefixXor = new int[nums.length];

    prefixXor[0] = nums[0];

    for (int i = 1; i < nums.length; i++) {
      prefixXor[i] = prefixXor[i - 1] ^ nums[i];
    }

    int subArrayCount = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);

    for (int i = 0; i < prefixXor.length; i++) {
      if (map.containsKey(prefixXor[i] ^ K)) {
        subArrayCount += map.get(prefixXor[i] ^ K);
      }

      map.put(prefixXor[i], map.getOrDefault(prefixXor[i], 0) + 1);
    }

    return subArrayCount;
  }
}
