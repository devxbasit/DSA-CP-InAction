// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
class Solution {

    class Pair implements Comparable<Pair> {

        int i;
        int j;
        int val;

        Pair(int i, int j, int val) {

            this.i = i;
            this.j = j;
            this.val = val;

        }

        @Override
        public int compareTo(Pair p) {

            return this.val - p.val;

        }
    }

    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Pair> minHeap = new PriorityQueue<>();

        for (int i = 0; i < matrix.length; i++) {

            minHeap.add(new Pair(0, i, matrix[0][i]));

        }

        while (k-- > 1) {

            Pair pair = minHeap.remove();

            if (pair.i != matrix.length - 1) {

                minHeap.add(new Pair(pair.i + 1, pair.j, matrix[pair.i + 1][pair.j]));

            }

        }

        return minHeap.peek().val;
    }
}