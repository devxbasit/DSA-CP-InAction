// { Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                // adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.bfsOfGraph(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        
         ArrayList<Integer> al = new ArrayList<>();
        
        boolean visited[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(0);
        visited[0] = true;
        
        
    
        int u, v, n;
        
        while (!queue.isEmpty()) {
            
            u = queue.remove();
            
            al.add(u);
                
                
            n = adj.get(u).size();
            
            for (int j = 0; j < n;  j++) {
                
                v = adj.get(u).get(j);
            
                if (!visited[v]) {
                    
                    queue.add(v);
                    visited[v] = true;
                    
                }
            }
        }
        
        return al;
    }
}