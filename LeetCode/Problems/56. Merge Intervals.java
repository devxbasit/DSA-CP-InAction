// https://leetcode.com/problems/merge-intervals/
class Solution {

    class Pair {

        int i;
        int j;

        Pair(int i, int j) {

            this.i = i;
            this.j = j;

        }

    }

    public int[][] merge(int[][] intervals) {

        // sort intervals based on their start time/i

        Arrays.sort(intervals, new Comparator<int[]>() {

            public int compare(int a[], int b[]) {

                return a[0] - b[0];

            }

        });

        List<Pair> al = new ArrayList<>();

        Pair pair = new Pair(intervals[0][0], intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {

            // if previous is end/j greater than current start/i
            if (pair.j >= intervals[i][0]) {

                // update j = Max(old j, new j)
                pair.j = Math.max(pair.j, intervals[i][1]);

                continue;

            }

            al.add(pair);

            pair = new Pair(intervals[i][0], intervals[i][1]);

        }

        al.add(pair);

        int mergedIntervals[][] = new int[al.size()][2];

        for (int i = 0; i < al.size(); i++) {

            mergedIntervals[i][0] = al.get(i).i;
            mergedIntervals[i][1] = al.get(i).j;

        }

        return mergedIntervals;
    }
}
