// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass {

  public static void main(String args[]) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(read.readLine());
    while (t-- > 0) {
      String str[] = read.readLine().trim().split(" ");
      int V = Integer.parseInt(str[0]);
      int E = Integer.parseInt(str[1]);

      ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
      for (int i = 0; i < V; i++) {
        adj.add(new ArrayList<ArrayList<Integer>>());
      }

      int i = 0;
      while (i++ < E) {
        String S[] = read.readLine().trim().split(" ");
        int u = Integer.parseInt(S[0]);
        int v = Integer.parseInt(S[1]);
        int w = Integer.parseInt(S[2]);
        ArrayList<Integer> t1 = new ArrayList<Integer>();
        ArrayList<Integer> t2 = new ArrayList<Integer>();
        t1.add(v);
        t1.add(w);
        t2.add(u);
        t2.add(w);
        adj.get(u).add(t1);
        adj.get(v).add(t2);
      }

      Solution ob = new Solution();

      System.out.println(ob.spanningTree(V, adj));
    }
  }
} // } Driver Code Ends

// User function Template for Java

class Solution {

  static class DSU {

    static int find(int parent[], int v) {
      if (parent[v] == v) {
        return v;
      }

      return find(parent, parent[v]);
    }

    void union(int parent[], int u, int v) {
      int Pu = find(parent, u);
      int Pv = find(parent, v);

      parent[Pv] = Pu;
    }
  }

  static class Edge implements Comparable<Edge> {

    int u;
    int v;
    int w;

    Edge(int u, int v, int w) {
      this.u = u;
      this.v = v;
      this.w = w;
    }

    public int compareTo(Edge e2) {
      return this.w - e2.w;
    }
  }

  static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
    // Add your code here

    boolean visited[] = new boolean[V];

    Queue<Edge> minHeap = new PriorityQueue<>();

    for (int i = 0; i < V; i++) {
      int u = i;
      visited[u] = true;

      for (int j = 0; j < adj.get(u).size(); j++) {
        int v = adj.get(u).get(j).get(0);
        int w = adj.get(u).get(j).get(1);

        if (!visited[v]) {
          Edge temp = new Edge(u, v, w);
          minHeap.add(temp);
        }
      }
    }

    int E = 0;
    int cost = 0;

    int parent[] = new int[V];

    for (int i = 0; i < V; i++) {
      parent[i] = i;
    }

    while (!minHeap.isEmpty() && E <= V - 1) {
      Edge e = minHeap.remove();

      int Pu = DSU.find(parent, e.u);
      int Pv = DSU.find(parent, e.v);

      if (Pu != Pv) {
        E++;

        cost += e.w;

        // DSU union
        parent[Pv] = Pu;
      }
    }

    return cost;
  }
}
