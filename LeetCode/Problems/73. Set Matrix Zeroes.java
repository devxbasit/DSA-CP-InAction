// https://leetcode.com/problems/set-matrix-zeroes/

// TC -> O(2 * (m * n)) - traversing the entire matrix 2 times
class Solution {

  public void setZeroes(int[][] matrix) {
    HashSet<Integer> rowSet = new HashSet<>();
    HashSet<Integer> colSet = new HashSet<>();

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          rowSet.add(i);
          colSet.add(j);
        }
      }
    }

    for (int row : rowSet) {
      for (int j = 0; j < matrix[0].length; j++) {
        matrix[row][j] = 0;
      }
    }

    for (int col : colSet) {
      for (int i = 0; i < matrix.length; i++) {
        matrix[i][col] = 0;
      }
    }
  }
}

// Approach 2
// TC -> O(2 * (m * n)) - traversing the entire matrix 2 times
class Solution {

  public void setZeroes(int[][] matrix) {
    boolean isFirstColZero = false, isFirstRowZero = false;

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          if (i == 0) isFirstRowZero = true;
          if (j == 0) isFirstColZero = true;

          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    for (int i = 1; i < matrix.length; i++) {
      if (matrix[i][0] == 0) {
        for (int j = 1; j < matrix[0].length; j++) {
          matrix[i][j] = 0;
        }
      }
    }

    for (int j = 1; j < matrix[0].length; j++) {
      if (matrix[0][j] == 0) {
        for (int i = 1; i < matrix.length; i++) {
          matrix[i][j] = 0;
        }
      }
    }

    if (isFirstRowZero) {
      for (int j = 0; j < matrix[0].length; j++) {
        matrix[0][j] = 0;
      }
    }

    if (isFirstColZero) {
      for (int i = 0; i < matrix.length; i++) {
        matrix[i][0] = 0;
      }
    }
  }
}

// Approach 3 - similar as Approach 2, but with 1 flag only
class Solution {

  public void setZeroes(int[][] matrix) {
    int col0 = 1;
    // matrix[0][0] will be used to store info about first row, col0 for first column

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;

          if (j == 0) {
            col0 = 0;
          } else {
            matrix[0][j] = 0;
          }
        }
      }
    }

    for (int i = 1; i < matrix.length; i++) {
      if (matrix[i][0] == 0) {
        for (int j = 1; j < matrix[0].length; j++) {
          matrix[i][j] = 0;
        }
      }
    }

    for (int j = 1; j < matrix[0].length; j++) {
      if (matrix[0][j] == 0) {
        for (int i = 1; i < matrix.length; i++) {
          matrix[i][j] = 0;
        }
      }
    }

    // check for first row
    if (matrix[0][0] == 0) {
      for (int j = 0; j < matrix[0].length; j++) {
        matrix[0][j] = 0;
      }
    }

    // check for first column
    if (col0 == 0) {
      for (int i = 0; i < matrix.length; i++) {
        matrix[i][0] = 0;
      }
    }
  }
}
