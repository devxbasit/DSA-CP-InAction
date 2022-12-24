class Solution {
    
    void bfs(char grid[][], int i, int j) {
        
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            
            return;
            
        }
        
        if (grid[i][j] == '0') {
            
            return;
            
        }
        
        grid[i][j] = '0';
        
        int row[] = new int[] {-1, 0, 1, 0};
        int col[] = new int[] {0, 1, 0, -1};
        
        for (int x = 0; x < 4; x++) {
            
            bfs(grid, i + row[x], j + col[x]);
            
        }
        
    }
    
    public int numIslands(char[][] grid) {
        
        int islands = 0;
        
        for (int i = 0; i < grid.length; i++) {
            
            for (int j = 0; j < grid[0].length; j++) {
                
                if (grid[i][j] == '1') {
                    
                    islands++;
                    bfs(grid, i, j);
                    
                }
            }
        }
        
        return islands;
    }
}