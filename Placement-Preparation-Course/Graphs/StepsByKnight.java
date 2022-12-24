// { Driver Code Starts
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
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends


class Solution
{
    
    class Node {
       
        int i;
        int j;
        
        int steps;
        
        Node (int i, int j, int steps) {
            
            this.i = i;
            this.j = j;
            this.steps = steps;
            
        }
        
   }
    
    
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        
        boolean visited[][] = new boolean[N][N];
        
        int Ti, Tj;
         
        Ti = TargetPos[0] - 1;
        Tj = TargetPos[1] - 1;
        
        int Ki, Kj;
         
        Ki = KnightPos[0] - 1;
        Kj = KnightPos[1] - 1;
         
        Queue<Node> queue = new LinkedList<>();
         
        queue.add(new Node(Ki, Kj, 0));
        
        
        // clock wise direction starting from top
        int rowIndexes[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
        int colIndexes[] = { 1, 2, 2, 1, -1, -2, -2, -1};
        
         
        while (!queue.isEmpty()) {
            
            Node node = queue.remove();
            
            if (visited[node.i][node.j]) {
                
                continue;
                
            }
            
            if (node.i == Ti && node.j == Tj) {
                
                return node.steps;
                
            }
            
            visited[node.i][node.j] = true;
            
            
            for (int i = 0; i < 8; i++) {
                
                int r = node.i + rowIndexes[i];
                int c = node.j + colIndexes[i];
                
        
                if (r < 0 || r >= N || c < 0 || c >= N) {
                    
                    continue;
                    
                }
                
                queue.add(new Node(r, c, node.steps + 1));
            }
        }
        
        return -1 ;
    }
}