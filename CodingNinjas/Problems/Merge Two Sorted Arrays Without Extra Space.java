// https://www.codingninjas.com/studio/problems/merge-two-sorted-arrays-without-extra-space_6898839
// https://www.youtube.com/watch?v=n7uwj04E0I4

import java.lang.Math;
import java.util.Arrays;

// TC -> O(min(m, n)) + O(NLogN) + O(MLogM) = O(min(m, n) + NLogN + MLogM)

public class Solution {

  public static void mergeTwoSortedArraysWithoutExtraSpace(long[] a, long[] b) {
    // Write your code here.

    int i = a.length - 1;
    int j = 0;

    while (i > -1 && j < b.length - 1 && a[i] > b[j]) {
      swap(a, b, i, j);
      i--;
      j++;
    }

    Arrays.sort(a);
    Arrays.sort(b);
  }

  public static void swap(long[] nums1, long[] nums2, int i, int j) {
    long temp = nums1[i];
    nums1[i] = nums2[j];
    nums2[j] = temp;
  }
}

// TC -> O(Log(N + M) * O(N + M))
public class Solution {

  public static void mergeTwoSortedArraysWithoutExtraSpace(
    long[] nums1,
    long[] nums2
  ) {
    int len = nums1.length + nums2.length;
    int gap = (int) Math.ceil(len / 2.0);
    // int gap = len / 2 + len % 2;

    while (gap > 0) {
      int low = 0, high = low + gap;

      while (high < len) {
        if (high < nums1.length) {
          // both in first array
          swapIfGreater(nums1, nums1, low, high);
        } else if (low < nums1.length) {
          // one in first, one in second array
          swapIfGreater(nums1, nums2, low, high - nums1.length);
        } else {
          // both in second array
          swapIfGreater(nums2, nums2, low - nums1.length, high - nums1.length);
        }

        low++;
        high++;
      }

      if (gap == 1) break;

      gap = (int) Math.ceil(gap / 2.0);
    }
  }

  public static void swapIfGreater(long[] nums1, long[] nums2, int i, int j) {
    if (nums1[i] > nums2[j]) {
      long temp = nums1[i];
      nums1[i] = nums2[j];
      nums2[j] = temp;
    }
  }
}
