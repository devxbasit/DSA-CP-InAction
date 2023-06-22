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

      int S = Integer.parseInt(read.readLine());

      Solution ob = new Solution();

      int[] ptr = ob.dijkstra(V, adj, S);

      for (i = 0; i < V; i++) System.out.print(ptr[i] + " ");
      System.out.println();
    }
  }
} // } Driver Code Ends

//User function Template for Java

/*
 *   adj: vector of vectors which represents the graph
 *   S: source vertex to start traversing graph with
 *   V: number of vertices
 */
class Solution {

  static int getMin(int distance[], boolean visited[]) {
    int min = Integer.MAX_VALUE;
    int minIndex = -1;

    for (int i = 0; i < distance.length; i++) {
      if (!visited[i] && distance[i] < min) {
        min = distance[i];
        minIndex = i;
      }
    }

    return minIndex;
  }

  static int[] dijkstra(
    int V,
    ArrayList<ArrayList<ArrayList<Integer>>> adj,
    int S
  ) {
    // Write your code here

    int distance[] = new int[V];
    boolean visited[] = new boolean[V];

    for (int i = 0; i < V; i++) {
      distance[i] = Integer.MAX_VALUE;
      visited[i] = false;
    }

    distance[S] = 0;

    while (true) {
      int u = getMin(distance, visited);

      if (u == -1) {
        break;
      }

      visited[u] = true;

      for (int i = 0; i < adj.get(u).size(); i++) {
        int v = adj.get(u).get(i).get(0);
        int costUV = adj.get(u).get(i).get(1);

        if (!visited[v] && distance[u] + costUV < distance[v]) {
          distance[v] = distance[u] + costUV;
        }
      }
    }

    return distance;
  }
}
