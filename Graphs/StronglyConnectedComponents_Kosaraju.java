//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}
// } Driver Code Ends


//User function Template for Java

// adj : Adjacency list representing the graph
// V: No of vertices


class Solution
{
    
    void DFS(ArrayList<ArrayList<Integer>> adj, boolean visited[], Stack<Integer> stack, int u) {
        
        if (visited[u]) {
            
            return ;
            
        }
        
        visited[u] = true;
        
        for (int v = 0; v < adj.get(u).size(); v++) {
            
            DFS(adj, visited, stack, adj.get(u).get(v));
            
            
        }
        
        stack.push(u);
        
    }
    
    void DFS2(ArrayList<ArrayList<Integer>> adj, boolean visited[], Stack<Integer> stack, int u) {
        
        if (stack.isEmpty()) {
            
            return;
            
        }
        
        if (visited[u]) {
            
            return ;
            
        }
        
        visited[u] = true;
        
        for (int v = 0; v < adj.get(u).size(); v++) {
            
            DFS2(adj, visited, stack, adj.get(u).get(v));
            
        }
        
    }
    
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        //code here
        
        boolean visited[] = new boolean[V];
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < V; i++) {
            
            if (!visited[i]) {
                
                DFS(adj, visited, stack, i);
                
            }
        }
        
        ArrayList<ArrayList<Integer>> adjInverse = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            
            adjInverse.add(new ArrayList<Integer>());
            
        }
        
        
        for (int u = 0; u < V; u++) {
        
            for (int v = 0; v < adj.get(u).size(); v++) {
                
                adjInverse.get(adj.get(u).get(v)).add(u);
                
            }
            
        }
        
        
        int count = 0;
        boolean visited2[] = new boolean[V];
        
        while (!stack.isEmpty()) {
            
            if (!visited2[stack.peek()]) {
                
                DFS2(adjInverse, visited2, stack, stack.pop());
                count++;
                
            } else {
            
                stack.pop(); 
                
            }
    
        }
    
        
        return count;
    }
}
