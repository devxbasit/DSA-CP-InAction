// https://www.codingninjas.com/studio/problems/merge-two-sorted-arrays-without-extra-space_6898839
// https://www.youtube.com/watch?v=n7uwj04E0I4

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
