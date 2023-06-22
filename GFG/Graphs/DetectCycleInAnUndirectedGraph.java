import java.io.*;

class GFG {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine().trim());
    while (T-- > 0) {
      String[] s = br.readLine().trim().split(" ");
      int V = Integer.parseInt(s[0]);
      int E = Integer.parseInt(s[1]);
      ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
      for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
      for (int i = 0; i < E; i++) {
        String[] S = br.readLine().trim().split(" ");
        int u = Integer.parseInt(S[0]);
        int v = Integer.parseInt(S[1]);
        adj.get(u).add(v);
        adj.get(v).add(u);
      }
      Solution obj = new Solution();
      boolean ans = obj.isCycle(V, adj);
      if (ans) System.out.println("1"); else System.out.println("0");
    }
  }
} // } Driver Code Ends

class Solution {

  boolean detectCycle(
    int V,
    ArrayList<ArrayList<Integer>> adj,
    boolean visited[],
    int u,
    int parent
  ) {
    visited[u] = true;

    int v, n = adj.get(u).size();

    for (int i = 0; i < n; i++) {
      v = adj.get(u).get(i);

      if (!visited[v]) {
        if (detectCycle(V, adj, visited, v, u)) {
          return true;
        }
      } else if (parent != v) {
        return true;
      }
    }

    return false;
  }

  public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
    // Code here

    boolean visited[] = new boolean[V];

    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        if (detectCycle(V, adj, visited, i, -1)) {
          return true;
        }
      }
    }

    return false;
  }
}
