// https://leetcode.com/problems/valid-sudoku/
class Solution {

  public boolean isValidSudoku(char[][] board) {
    HashSet<String> hs = new HashSet<>();

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == '.') continue;

        String rowEntry = "row-" + i + "-" + board[i][j];
        String colEntry = "col-" + j + "-" + board[i][j];

        // (i / x )* 3 adds offset of previous boxes

        // (j / 3) give either 0, 1, 2

        // (i / 3) * 3 + (j / 3)
        // offset      + (0 or 1 or 2)

        String boxEntry = "box-" + (i / 3) * 3 + (j / 3) + "-" + board[i][j];

        if (
          hs.contains(rowEntry) ||
          hs.contains(colEntry) ||
          hs.contains(boxEntry)
        ) return false;

        hs.add(rowEntry);
        hs.add(colEntry);
        hs.add(boxEntry);
      }
    }

    return true;
  }
}
