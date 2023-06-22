import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while (t-- > 0) {
      ArrayList<ArrayList<Integer>> list = new ArrayList<>();
      int V = sc.nextInt();
      int E = sc.nextInt();
      for (int i = 0; i < V + 1; i++) list.add(i, new ArrayList<Integer>());
      for (int i = 0; i < E; i++) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        list.get(u).add(v);
      }
      if (new Solution().isCyclic(V, list) == true) System.out.println(
        "1"
      ); else System.out.println("0");
    }
  }
} // } Driver Code Ends

/*Complete the function below*/

class Solution {

  boolean detectCycle(
    int V,
    ArrayList<ArrayList<Integer>> adj,
    boolean visited[],
    boolean recStack[],
    int u
  ) {
    if (recStack[u]) {
      return true;
    }

    if (visited[u]) {
      return false;
    }

    visited[u] = true;
    recStack[u] = true;

    int v, n = adj.get(u).size();

    for (int i = 0; i < n; i++) {
      v = adj.get(u).get(i);

      if (detectCycle(V, adj, visited, recStack, v)) {
        return true;
      }
    }

    recStack[u] = false;
    return false;
  }

  public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
    // code here

    boolean visited[] = new boolean[V];
    boolean recStack[] = new boolean[V];

    for (int i = 0; i < V; i++) {
      if (detectCycle(V, adj, visited, recStack, i)) {
        return true;
      }
    }

    return false;
  }
}
