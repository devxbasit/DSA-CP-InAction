import java.io.*;
import java.util.*;

class GridPaths {

  public static int noOfWays(int board[][], int n) {
    if (board[0][0] == -1 || board[n - 1][n - 1] == -1) return 0;

    board[n - 1][n - 1] = 1;

    // fill last row
    for (int col = n - 2; col >= 0; col--) {
      if (board[n - 1][col] == -1) {
        board[n - 1][col] = 0;
        continue;
      }

      board[n - 1][col] += board[n - 1][col + 1];
    }

    // fill last col
    for (int row = n - 2; row >= 0; row--) {
      if (board[row][n - 1] == -1) {
        board[row][n - 1] = 0;
        continue;
      }

      board[row][n - 1] += board[row + 1][n - 1];
    }

    int MOD = 1000000007;

    for (int row = n - 2; row >= 0; row--) {
      for (int col = n - 2; col >= 0; col--) {
        if (board[row][col] == -1) {
          board[row][col] = 0;
          continue;
        }

        board[row][col] =
          (board[row + 1][col] % MOD + board[row][col + 1] % MOD) % MOD;
      }
    }

    return board[0][0];
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine().trim());

    String S = "";

    for (int i = 0; i < n; i++) S += br.readLine().trim();

    int board[][] = new int[n][n];
    int index = -1;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (S.charAt(++index) == '*') {
          board[i][j] = -1;
        }
      }
    }

    System.out.println(noOfWays(board, n));
  }
}
