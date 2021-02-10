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
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


class Solution
{
    
    void DFS(char grid[][], int row, int col, int i, int j) {
        
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] != '1') {
            
            return;
            
        }
        
        grid[i][j] = '0';
        
        // clock wise direction starting from top, diagonals included
        
        int rowIndexs[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
        int colIndexs[] = { 0, 1, 1, 1, 0, -1, -1, -1};
        
        for (int x = 0; x < 8; x++) {
            
            DFS(grid, row, col, i + rowIndexs[x], j + colIndexs[x]);
            
        }
        
        
    }
    
    
    public int numIslands(char[][] grid)
    {
        // Code here
        
        int row = grid.length;
        int col = grid[0].length;
        
        int islands = 0;
        
        for (int i = 0; i < row; i++) {
            
            for  (int j = 0; j < col; j++) {
                
                if (grid[i][j] == '1') {
                
                    DFS(grid, row, col, i, j);
                    
                    islands++;

                }
            }
        }
        
        return islands;
        
    }
}