//https://www.youtube.com/watch?v=gYmWHvRHu-s

import java.util.*;

// TC -> N * Log( (sum(arr[]) - max(arr[])) + 1)
public class Solution {

  public static int findPages(ArrayList<Integer> arr, int n, int m) {
    // Write your code here.

    int[] books = arr.stream().mapToInt(i -> i).toArray();

    if (m > n) return -1;

    int totalPages = 0;
    int maxPages = Integer.MIN_VALUE;

    for (int i = 0; i < books.length; i++) {
      totalPages += books[i];
      maxPages = Math.max(maxPages, books[i]);
    }

    if (m == n) return maxPages;

    return binarySearch(books, maxPages, totalPages, m);
  }

  public static int binarySearch(
    int[] books,
    int low,
    int high,
    int totalStudents
  ) {
    if (low <= high) {
      int mid = low + (high - low) / 2;

      if (calculateStudents(books, mid) <= totalStudents) {
        return binarySearch(books, low, mid - 1, totalStudents);
      } else {
        return binarySearch(books, mid + 1, high, totalStudents);
      }
    }

    return low;
  }

  public static int calculateStudents(int[] books, int pages) {
    int assignedStudents = 0;
    int tempAllocatedPages = 0;

    for (int i = 0; i < books.length; i++) {
      if (tempAllocatedPages + books[i] > pages) {
        assignedStudents++;
        tempAllocatedPages = books[i];
      } else {
        tempAllocatedPages += books[i];
      }
    }

    assignedStudents++;

    return assignedStudents;
  }
}
