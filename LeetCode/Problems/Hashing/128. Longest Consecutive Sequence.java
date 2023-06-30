//https://leetcode.com/problems/longest-consecutive-sequence/description/

// TC -> O(N * Log(N)) + O(N) = O(N * Log(N))
class Solution {

  public int longestConsecutive(int[] nums) {
    if (nums.length < 2) return nums.length;

    Arrays.sort(nums);

    int maxSequence = Integer.MIN_VALUE;
    int currMaxSequence = 1;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] == nums[i]) continue;

      if (nums[i - 1] + 1 == nums[i]) {
        currMaxSequence++;
      } else {
        maxSequence = Math.max(maxSequence, currMaxSequence);
        currMaxSequence = 1;
      }
    }

    return currMaxSequence > maxSequence ? currMaxSequence : maxSequence;
  }
}

// Approach 2
// TC -> O(N)
class Solution {

  public int longestConsecutive(int[] nums) {
    HashSet<Integer> set = new HashSet<>();

    for (int i = 0; i < nums.length; i++) {
      set.add(nums[i]);
    }

    int maxConsecutiveSequence = Integer.MIN_VALUE;

    for (int num : set) {
      if (set.contains(num - 1)) continue;

      int currentConsecutiveSequence = 1;
      int nextNum = num + 1;

      while (set.contains(nextNum++)) {
        currentConsecutiveSequence++;
      }

      maxConsecutiveSequence =
        Math.max(maxConsecutiveSequence, currentConsecutiveSequence);
    }

    return maxConsecutiveSequence == Integer.MIN_VALUE
      ? 0
      : maxConsecutiveSequence;
  }
}
