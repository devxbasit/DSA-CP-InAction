// https://leetcode.com/problems/spiral-matrix/

// TC -> O(m * n)

class Solution {

  public List<Integer> spiralOrder(int[][] matrix) {
    int right = matrix[0].length, bottom = matrix.length;
    List<Integer> list = new ArrayList<>();

    for (int i = 0, j = 0; i < bottom && j < right; i++, j++) {
      for (int row = i, col = j; col < right; col++) {
        list.add(matrix[row][col]);
      }

      for (int row = i + 1, col = right - 1; row < bottom; row++) {
        list.add(matrix[row][col]);
      }

      // below two passes can overlap, bottom with top, left with right, so extra check
      for (int row = bottom - 1, col = right - 2; col >= i && row != i; col--) {
        list.add(matrix[row][col]);
      }

      for (int row = bottom - 2, col = i; row > i && col != right - 1; row--) {
        list.add(matrix[row][col]);
      }

      right--;
      bottom--;
    }

    return list;
  }
}
// Approach 2 - use 4 pointer, top, right, bottom, left
