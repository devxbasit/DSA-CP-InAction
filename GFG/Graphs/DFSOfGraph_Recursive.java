// { Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine().trim());
    while (T-- > 0) {
      String[] s = br.readLine().trim().split(" ");
      int V = Integer.parseInt(s[0]);
      int E = Integer.parseInt(s[1]);
      ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
      for (int i = 0; i < V; i++) adj.add(new ArrayList<Integer>());
      for (int i = 0; i < E; i++) {
        String[] S = br.readLine().trim().split(" ");
        int u = Integer.parseInt(S[0]);
        int v = Integer.parseInt(S[1]);
        adj.get(u).add(v);
        adj.get(v).add(u);
      }
      Solution obj = new Solution();
      ArrayList<Integer> ans = obj.dfsOfGraph(V, adj);
      for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
      System.out.println();
    }
  }
}

// } Driver Code Ends

class Solution {

  void DFSRecur(
    int V,
    ArrayList<ArrayList<Integer>> adj,
    boolean visited[],
    int u,
    ArrayList<Integer> al
  ) {
    if (visited[u]) return;

    visited[u] = true;
    al.add(u);

    int n = adj.get(u).size();

    for (int j = 0; j < n; j++) {
      DFSRecur(V, adj, visited, adj.get(u).get(j), al);
    }
  }

  public ArrayList<Integer> dfsOfGraph(
    int V,
    ArrayList<ArrayList<Integer>> adj
  ) {
    // Code here

    boolean visited[] = new boolean[V];

    ArrayList<Integer> al = new ArrayList<>();

    DFSRecur(V, adj, visited, 0, al);

    return al;
  }
}
