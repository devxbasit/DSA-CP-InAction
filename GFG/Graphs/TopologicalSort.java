import java.io.*;
import java.lang.*;
import java.util.*;

class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(read.readLine());

    while (t-- > 0) {
      ArrayList<ArrayList<Integer>> list = new ArrayList<>();
      String st[] = read.readLine().trim().split("\\s+");
      int edg = Integer.parseInt(st[0]);
      int nov = Integer.parseInt(st[1]);

      for (int i = 0; i < nov + 1; i++) list.add(i, new ArrayList<Integer>());

      int p = 0;
      for (int i = 1; i <= edg; i++) {
        String s[] = read.readLine().trim().split("\\s+");
        int u = Integer.parseInt(s[0]);
        int v = Integer.parseInt(s[1]);
        list.get(u).add(v);
      }

      int[] res = new Solution().topoSort(nov, list);

      if (check(list, nov, res) == true) System.out.println(
        "1"
      ); else System.out.println("0");
    }
  }

  static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
    int[] map = new int[V];
    for (int i = 0; i < V; i++) {
      map[res[i]] = i;
    }
    for (int i = 0; i < V; i++) {
      for (int v : list.get(i)) {
        if (map[i] > map[v]) return false;
      }
    }
    return true;
  }
}

// } Driver Code Ends

/*Complete the function below*/

/*
ArrayList<ArrayList<>Integer>adj: to represent graph containing 'N' vertices
                                    and edges between them
N: represent number of vertices
*/
class Solution {

  static void postorderRecur(
    int V,
    ArrayList<ArrayList<Integer>> adj,
    boolean visited[],
    Stack<Integer> stack,
    int u
  ) {
    if (visited[u]) {
      return;
    }

    visited[u] = true;

    int v, n = adj.get(u).size();

    for (int i = 0; i < n; i++) {
      v = adj.get(u).get(i);

      postorderRecur(V, adj, visited, stack, v);
    }

    stack.push(u);
    return;
  }

  static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
    // add your code here

    Stack<Integer> stack = new Stack<Integer>();

    boolean visited[] = new boolean[V];

    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        postorderRecur(V, adj, visited, stack, i);
      }
    }

    int sorted[] = new int[V];
    int i = 0;

    while (!stack.isEmpty()) {
      sorted[i] = stack.pop();
      i++;
    }

    return sorted;
  }
}
