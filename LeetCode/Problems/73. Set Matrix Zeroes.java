// https://leetcode.com/problems/set-matrix-zeroes/
class Solution {

  public void setZeroes(int[][] matrix) {
    // method 1
    // another method is use two 1D arrays, one for row and second for col
    // and set corresponding row index or column index zero in 1D array

    // method 2
    // use first row and first col of given array as indexes

    boolean firstColIsZero = false;

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          if (j == 0) {
            firstColIsZero = true;

            // mark row entry only
            matrix[i][0] = 0;
            continue;
          }

          // row entry
          matrix[i][0] = 0;

          // col entry
          matrix[0][j] = 0;
        }
      }
    }

    // ***
    // start from 1,1

    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    // check for first row
    if (matrix[0][0] == 0) {
      for (int col = 0; col < matrix[0].length; col++) {
        matrix[0][col] = 0;
      }
    }

    // check for first col
    if (firstColIsZero) {
      for (int row = 0; row < matrix.length; row++) {
        matrix[row][0] = 0;
      }
    }
  }
}
