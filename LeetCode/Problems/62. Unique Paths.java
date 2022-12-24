class Solution {
    
    public int uniquePaths(int m, int n) {
        
        int matrix[][] = new int [m][n];
        
        // one possible way to reach destination from destination point is to dont make any move - phi / null set
            
        matrix[matrix.length - 1][matrix[0].length - 1] = 1;
        
        // fill last column    
        for (int i = 0; i < matrix.length - 1; i++) {
            
            matrix[i][matrix[0].length - 1] = 1;
            
        }
        
    
        // fill last row
        for (int i = 0; i < matrix[0].length - 1; i++) {
            
            matrix[matrix.length - 1][i] = 1;
            
        }
        
        for (int i = matrix.length - 2; i >= 0; i--) {
            
            for (int j = matrix[0].length - 2; j >= 0; j--) {
                
                matrix[i][j] = matrix[i][j + 1] + matrix[i + 1][j];
                
            }
        }
        
        return matrix[0][0];
        
    }
}