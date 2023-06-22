// https://leetcode.com/problems/word-search/
class Solution {

  // same as method 1, but without visited array
  boolean DFS(char board[][], int i, int j, String word, int counter) {
    if (counter >= word.length()) {
      return true;
    }

    if (
      i < 0 ||
      i >= board.length ||
      j < 0 ||
      j >= board[0].length ||
      board[i][j] == ' ' ||
      board[i][j] != word.charAt(counter)
    ) {
      return false;
    }

    char temp = board[i][j];
    board[i][j] = ' ';

    int rowIndexes[] = new int[] { -1, 0, 1, 0 };
    int colIndexes[] = new int[] { 0, 1, 0, -1 };

    for (int x = 0; x < 4; x++) {
      if (DFS(board, i + rowIndexes[x], j + colIndexes[x], word, counter + 1)) {
        return true;
      }
    }

    board[i][j] = temp;
    return false;
  }

  public boolean exist(char[][] board, String word) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == word.charAt(0)) {
          if (DFS(board, i, j, word, 0)) {
            return true;
          }
        }
      }
    }

    return false;
  }
}
