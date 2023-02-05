// https://leetcode.com/problems/spiral-matrix/
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int c1, c2, r1, r2;

        c1 = 0;
        c2 = matrix[0].length - 1;

        r1 = 0;
        r2 = matrix.length - 1;

        List<Integer> al = new ArrayList<>();

        while (c1 < c2 && r1 < r2) {

            for (int i = c1; i < c2; i++) {

                al.add(matrix[r1][i]);

            }

            for (int i = r1; i < r2; i++) {

                al.add(matrix[i][c2]);

            }

            for (int i = c2; i > c1; i--) {

                al.add(matrix[r2][i]);

            }

            for (int i = r2; i > r1; i--) {

                al.add(matrix[i][c1]);

            }

            r1++;
            r2--;

            c1++;
            c2--;

        }

        if (al.size() == matrix.length * matrix[0].length)
            return al;

        // either one row is left or one column is left

        if (r1 == r2) {

            // add column
            while (c1 <= c2) {

                al.add(matrix[r1][c1]);
                c1++;

            }

        } else {

            // add row
            while (r1 <= r2) {

                al.add(matrix[r1][c1]);
                r1++;

            }

        }

        return al;

    }
}