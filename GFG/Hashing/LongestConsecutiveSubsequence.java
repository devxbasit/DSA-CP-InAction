// https://practice.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1

class GfG {

  // Function to find Longest Consecutive Subsequence
  int findLongestConseqSubseq(int arr[], int n) {
    // Your code here

    HashSet<Integer> hs = new HashSet<>();

    for (int i = 0; i < n; i++) hs.add(arr[i]);

    int max = -1;
    int j;

    for (int i = 0; i < n; i++) {
      if (!hs.contains(arr[i] - 1)) {
        j = arr[i] + 1;

        while (hs.contains(j)) j++;

        max = Math.max(max, j - arr[i]);
      }
    }

    return max;
  }
}

// Approach 2

class Solution {

  // arr[] : the input array
  // N : size of the array arr[]

  //Function to return length of longest subsequence of consecutive integers.
  static int findLongestConseqSubseq(int nums[], int N) {
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
