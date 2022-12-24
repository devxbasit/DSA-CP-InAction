class Solution {
    
    // same as method 2, but with visited array
    boolean DFS(char board[][], boolean visited[][], int i, int j, String word, int counter) {
        
        
        if (counter >= word.length()) {
            
            
            return true;
            
        }
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(counter)) {
            
            return false;
            
        }
        
        visited[i][j] = true;
        
        int rowIndexes[] = new int []{-1, 0, 1, 0};
        int colIndexes[] = new int[]{0, 1, 0, -1};
        
        for (int x = 0; x < 4; x++) {
            
            if (DFS(board, visited, i + rowIndexes[x], j + colIndexes[x], word, counter + 1)) {
                
                return true;
                
            }
            
        }
        
        visited[i][j] = false;
        return false;
        
    }
    
    public boolean exist(char[][] board, String word) {
        
        for (int i = 0; i < board.length; i++) {
            
            for (int j = 0; j < board[0].length; j++) {
                
                
                if (board[i][j] == word.charAt(0)) {
                    
                    if (DFS(board, new boolean[board.length][board[0].length], i, j, word, 0)) {
                        
                        return true;
                        
                    }
                }
            }
        }
        
        return false;
    }
}