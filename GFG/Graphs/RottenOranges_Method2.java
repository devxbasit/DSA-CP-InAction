// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine().trim());
    while (T-- > 0) {
      String[] s = br.readLine().trim().split(" ");
      int n = Integer.parseInt(s[0]);
      int m = Integer.parseInt(s[1]);
      int[][] grid = new int[n][m];
      for (int i = 0; i < n; i++) {
        String[] S = br.readLine().trim().split(" ");
        for (int j = 0; j < m; j++) {
          grid[i][j] = Integer.parseInt(S[j]);
        }
      }
      Solution obj = new Solution();
      int ans = obj.orangesRotting(grid);
      System.out.println(ans);
    }
  }
} // } Driver Code Ends

class Solution {

  class Node {

    int i;
    int j;

    Node(int i, int j) {
      this.i = i;
      this.j = j;
    }
  }

  public int orangesRotting(int[][] grid) {
    // Code here

    // same as method 1, but using delimiter

    Queue<Node> queue = new LinkedList<>();

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 2) {
          queue.add(new Node(i, j));
        }
      }
    }

    //add delimiter
    queue.add(new Node(-1, -1));

    int maxTime = 0;
    int rowIndexs[] = new int[] { -1, 0, 1, 0 };
    int colIndexs[] = new int[] { 0, 1, 0, -1 };

    while (!queue.isEmpty()) {
      Node node = queue.remove();

      if (node.i == -1) {
        if (!queue.isEmpty()) {
          maxTime++;
          queue.add(node);
        }

        continue;
      }

      for (int i = 0; i < 4; i++) {
        int r = node.i + rowIndexs[i];
        int c = node.j + colIndexs[i];

        if (
          r < 0 ||
          r >= grid.length ||
          c < 0 ||
          c >= grid[0].length ||
          grid[r][c] == 0 ||
          grid[r][c] == 2
        ) {
          continue;
        }

        grid[r][c] = 2;

        queue.add(new Node(r, c));
      }
    }

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          return -1;
        }
      }
    }

    return maxTime;
  }
}
