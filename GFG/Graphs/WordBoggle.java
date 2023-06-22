//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t > 0) {
      int N = sc.nextInt();
      String[] dictionary = new String[N];
      for (int i = 0; i < N; i++) {
        dictionary[i] = sc.next();
      }

      int R = Integer.parseInt(sc.next());
      int C = Integer.parseInt(sc.next());

      char board[][] = new char[R][C];
      for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
          board[i][j] = sc.next().charAt(0);
        }
      }

      Solution obj = new Solution();
      String[] ans = obj.wordBoggle(board, dictionary);

      if (ans.length == 0) System.out.println("-1"); else {
        Arrays.sort(ans);
        for (int i = 0; i < ans.length; i++) {
          System.out.print(ans[i] + " ");
        }
        System.out.println();
      }

      t--;
    }
  }
}

// } Driver Code Ends

//User function Template for Java

class Solution {

  class Pair {

    int i;
    int j;

    Pair(int i, int j) {
      this.i = i;
      this.j = j;
    }
  }

  boolean DFS(
    char board[][],
    boolean visited[][],
    int i,
    int j,
    String word,
    int counter
  ) {
    if (counter >= word.length()) {
      return true;
    }

    if (
      i < 0 ||
      i >= board.length ||
      j < 0 ||
      j >= board[0].length ||
      visited[i][j] ||
      board[i][j] != word.charAt(counter)
    ) {
      return false;
    }

    visited[i][j] = true;

    int rowIndexes[] = new int[] { -1, -1, 0, 1, 1, 1, 0, -1 };
    int colIndexes[] = new int[] { 0, 1, 1, 1, 0, -1, -1, -1 };

    for (int x = 0; x < 8; x++) {
      if (
        DFS(
          board,
          visited,
          i + rowIndexes[x],
          j + colIndexes[x],
          word,
          counter + 1
        )
      ) {
        return true;
      }
    }

    visited[i][j] = false;
    return false;
  }

  public String[] wordBoggle(char board[][], String[] dictionary) {
    // Write your code here

    HashMap<Character, ArrayList<Pair>> hm = new HashMap<>();

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (hm.containsKey(board[i][j])) {
          ArrayList<Pair> temp = hm.get(board[i][j]);
          temp.add(new Pair(i, j));
        } else {
          ArrayList<Pair> temp = new ArrayList<>();
          temp.add(new Pair(i, j));

          hm.put(board[i][j], temp);
        }
      }
    }

    ArrayList<String> al = new ArrayList<>();

    for (int s = 0; s < dictionary.length; s++) {
      boolean visited[][] = new boolean[board.length][board[0].length];

      if (hm.containsKey(dictionary[s].charAt(0))) {
        for (int i = 0; i < hm.get(dictionary[s].charAt(0)).size(); i++) {
          ArrayList<Pair> list = hm.get(dictionary[s].charAt(0));

          if (
            DFS(board, visited, list.get(i).i, list.get(i).j, dictionary[s], 0)
          ) {
            al.add(dictionary[s]);
            break;
          }
        }
      }
    }

    return al.toArray(new String[al.size()]);
  }
}
