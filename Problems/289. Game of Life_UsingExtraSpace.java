class Solution {
    
    boolean die(int matrix[][], int i, int j) { 
        
        int liveNeighbours = 0;
        
        int row [] = new int[] { -1, -1, 0, 1, 1, 1, 0, -1 };
        int col [] = new int[] { 0, 1, 1, 1, 0, -1, -1, -1 };
        
        for (int x = 0; x < 8; x++) {
            
            int r = i + row[x]; 
            int c = j + col[x]; 
            
            if (r < 0 || c < 0 || r >= matrix.length || c >= matrix[0].length) continue;
                            
            if (matrix[i + row[x]][j + col[x]] == 1) {
                
                liveNeighbours++;
                
                if (liveNeighbours > 3) return true;
                
            }
            
            
        }
        
        return (liveNeighbours == 2 || liveNeighbours == 3) ? false : true ;
        
    }
    
    boolean alive(int matrix[][], int i, int j) {
        
        int liveNeighbours = 0;
        
        int row [] = new int[] { -1, -1, 0, 1, 1, 1, 0, -1 };
        int col [] = new int[] { 0, 1, 1, 1, 0, -1, -1, -1 };
        
        for (int x = 0; x < 8; x++) {
            
            int r = i + row[x]; 
            int c = j + col[x]; 
            
            if (r < 0 || c < 0 || r >= matrix.length || c >= matrix[0].length) continue;
                            
            if (matrix[i + row[x]][j + col[x]] == 1) {
                
                liveNeighbours++;
                
                if (liveNeighbours > 3) return false;
                
            }
            
            
        }
        
        return liveNeighbours == 3;
        
    }
    
    
    public void gameOfLife(int[][] board) {
        
        int nextState[][] = new int[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++) {
            
            for (int j = 0; j < board[0].length; j++) {
                
                if (board[i][j] == 1) {
                    
                    nextState[i][j] = die(board, i, j) ? 0 : 1;
                    continue;
                    
                }
                
                nextState[i][j] = alive(board, i, j) ? 1 : 0;
                
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            
            for (int j = 0; j < board[0].length; j++) {
                
                board[i][j] = nextState[i][j];
                
            }
            
        }
            
    }
}