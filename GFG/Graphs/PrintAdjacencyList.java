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
      ArrayList<ArrayList<Integer>> ans = obj.printGraph(V, adj);
      for (int i = 0; i < ans.size(); i++) {
        for (int j = 0; j < ans.get(i).size() - 1; j++) {
          System.out.print(ans.get(i).get(j) + "-> ");
        }
        System.out.print(ans.get(i).get(ans.get(i).size() - 1));
        System.out.println();
      }
    }
  }
} // } Driver Code Ends

class Solution {

  public ArrayList<ArrayList<Integer>> printGraph(
    int V,
    ArrayList<ArrayList<Integer>> adj
  ) {
    // Code here

    for (int i = 0; i < adj.size(); i++) adj.get(i).add(0, i);

    return adj;
  }
}
