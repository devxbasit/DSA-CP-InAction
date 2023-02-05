// https://leetcode.com/problems/surrounded-regions/
class Solution {

    void dfsMark(char board[][], boolean visited[][], int i, int j) {

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return;

        if (visited[i][j])
            return;

        visited[i][j] = true;

        if (board[i][j] == 'O') {

            board[i][j] = '$';

            int row[] = new int[] { -1, 0, 1, 0 };
            int col[] = new int[] { 0, 1, 0, -1 };

            for (int x = 0; x < 4; x++) {

                dfsMark(board, visited, i + row[x], j + col[x]);

            }

        }

    }

    public void solve(char[][] board) {

        int M = board.length;
        int N = board[0].length;

        boolean visited[][] = new boolean[M][N];

        // first row
        for (int i = 0; i < N; i++) {

            if (!visited[0][i] && board[0][i] == 'O') {

                dfsMark(board, visited, 0, i);

            }
        }

        // last row
        for (int i = 0; i < N; i++) {

            if (!visited[M - 1][i] && board[M - 1][i] == 'O') {

                dfsMark(board, visited, M - 1, i);

            }
        }

        // first col
        for (int i = 1; i < M - 1; i++) {

            if (!visited[i][0] && board[i][0] == 'O') {

                dfsMark(board, visited, i, 0);

            }
        }

        // last col
        for (int i = 1; i < M - 1; i++) {

            if (!visited[i][N - 1] && board[i][N - 1] == 'O') {

                dfsMark(board, visited, i, N - 1);

            }
        }

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == 'O') {

                    board[i][j] = 'X';

                } else if (board[i][j] == '$') {

                    board[i][j] = 'O';

                }
            }
        }

    }
}