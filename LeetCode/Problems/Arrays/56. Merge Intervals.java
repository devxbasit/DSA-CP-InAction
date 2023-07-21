// https://leetcode.com/problems/merge-intervals/

// TC -> O(NLogN) + O(N) = O(NLogN)
// SC -> O(N)
class Solution {

  public int[][] merge(int[][] intervals) {
    // Both way it works - quicksort or using comparator

    // quicksort(intervals, 0, intervals.length - 1);

    Arrays.sort(
      intervals,
      new Comparator<int[]>() {
        public int compare(int[] a, int[] b) {
          return a[0] - b[0];
        }
      }
    );

    List<int[]> intervalList = new ArrayList<>();

    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] > intervals[i - 1][1]) {
        intervalList.add(intervals[i - 1]);
      } else {
        intervals[i][0] = intervals[i - 1][0];
        intervals[i][1] = Math.max(intervals[i][1], intervals[i - 1][1]);
      }
    }

    intervalList.add(intervals[intervals.length - 1]);

    return intervalList.toArray(new int[intervalList.size()][]);
  }

  public void quicksort(int[][] intervals, int low, int high) {
    if (low < high) {
      int pi = partition(intervals, low, high);
      quicksort(intervals, low, pi - 1);
      quicksort(intervals, pi + 1, high);
    }
  }

  public int partition(int[][] intervals, int low, int high) {
    int pivot = high;

    int i = low - 1;

    for (int j = low; j < pivot; j++) {
      if (intervals[j][0] <= intervals[pivot][0]) {
        swap(intervals, ++i, 0, j, 0);
        swap(intervals, i, 1, j, 1);
      }
    }

    swap(intervals, ++i, 0, pivot, 0);
    swap(intervals, i, 1, pivot, 1);

    return i;
  }

  public void swap(int[][] intervals, int i, int j, int k, int l) {
    int temp = intervals[i][j];
    intervals[i][j] = intervals[k][l];
    intervals[k][l] = temp;
  }
}
// TBD - Approach 2: Connected Components
