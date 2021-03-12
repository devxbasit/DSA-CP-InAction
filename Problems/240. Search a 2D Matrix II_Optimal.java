class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row = matrix.length - 1;
        int col = 0;
        
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        
        while (row >= 0 && col >= 0 && row <= m && col <= n) {
            
        
            if (matrix[row][col] == target) return true;
            
            if (matrix[row][col] > target) {
                
                row--;
                
            } else {
                
                col++;
                
            }
            
        }
        
        return false;
        
    }
}