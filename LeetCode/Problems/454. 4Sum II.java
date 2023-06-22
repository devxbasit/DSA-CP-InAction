// https://leetcode.com/problems/4sum-ii/
class Solution {

  public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    // divide and conquer

    HashMap<Integer, Integer> hm1 = new HashMap<>();

    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < B.length; j++) {
        int sum = A[i] + B[j];

        hm1.put(sum, hm1.getOrDefault(sum, 0) + 1);
      }
    }

    int totalWays = 0;

    for (int i = 0; i < C.length; i++) {
      for (int j = 0; j < D.length; j++) {
        int sum = C[i] + D[j];

        sum = -sum;

        if (hm1.containsKey(sum)) {
          totalWays += hm1.get(sum);
        }
      }
    }

    return totalWays;
  }
}
