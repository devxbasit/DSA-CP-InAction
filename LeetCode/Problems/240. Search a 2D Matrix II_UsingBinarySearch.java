// https://leetcode.com/problems/search-a-2d-matrix-ii/
class Solution {

    boolean binarySearchOnRow(int matrix[][], int target, int row, int low, int high) {

        if (low > high)
            return false;

        int mid = low + ((high - low) / 2);

        if (matrix[row][mid] == target)
            return true;

        if (matrix[row][mid] > target) {

            return binarySearchOnRow(matrix, target, row, low, mid - 1);

        }

        return binarySearchOnRow(matrix, target, row, mid + 1, high);

    }

    boolean binarySearchOnCol(int matrix[][], int target, int col, int low, int high) {

        if (low > high)
            return false;

        int mid = low + (high - low) / 2;

        if (matrix[mid][col] == target)
            return true;

        if (matrix[mid][col] > target) {

            return binarySearchOnCol(matrix, target, col, low, mid - 1);

        }

        return binarySearchOnCol(matrix, target, col, mid + 1, high);

    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int row = 0;
        int col = 0;

        // m x n matrix
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;

        while (row <= m && col <= n) {

            if (matrix[row][col] == target)
                return true;

            if (matrix[row][col] > target)
                return false;

            // row search
            if (col <= n &&
                    binarySearchOnRow(matrix, target, row, col + 1, n))
                return true;

            // col search
            if (row <= m &&
                    binarySearchOnCol(matrix, target, col, row + 1, m))
                return true;

            row++;
            col++;

        }

        return false;
    }
}