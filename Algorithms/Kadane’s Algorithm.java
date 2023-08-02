// The idea of Kadane’s algorithm is to maintain a variable max_ending_here that stores the maximum sum contiguous subarray ending at current index and a variable max_so_far stores the maximum sum of contiguous subarray found so far, Everytime there is a positive-sum value in max_ending_here compare it with max_so_far and update max_so_far if it is greater than max_so_far.
// So the main Intuition behind Kadane’s algorithm is,
// – the subarray with negative sum is discarded (by assigning max_ending_here = 0 in code).
// – we carry subarray till it gives positive sum.

// A subarray with a sum less than 0 will always reduce our answer and so this type of subarray cannot be a part of the subarray with maximum sum.

// Pseudocode:
//     Initialize:
//         max_so_far = INT_MIN
//         max_ending_here = 0

//     Loop for each element of the array

//       (a) max_ending_here = max_ending_here + a[i]
//       (b) if(max_so_far < max_ending_here)
//                 max_so_far = max_ending_here
//       (c) if(max_ending_here < 0)root
r
//                 max_ending_here = 0
//     return max_so_far

// https://leetcode.com/problems/maximum-subarray/description/
// Leetcode -53. Maximum Subarray
class Solution {

  public int maxSubArray(int[] nums) {
    int maxSoFar = Integer.MIN_VALUE;
    int maxEndingHere = 0;

    for (int i = 0; i < nums.length; i++) {
      maxEndingHere += nums[i];
      maxSoFar = Math.max(maxSoFar, maxEndingHere);

      if (maxEndingHere <= 0) {
        maxEndingHere = 0;
      }
    }

    return maxSoFar;
  }
}
