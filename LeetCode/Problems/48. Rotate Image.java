class Solution {
    
    void rowReverse(int matrix[][]) {
        
        for (int row = 0; row < matrix.length; row++) {
            
            int low = 0; 
            int high = matrix.length - 1;
            int temp;
            
            while (low < high) {
                
                temp = matrix[row][low] ;
                matrix[row][low] = matrix[row][high];
                matrix[row][high] = temp;
                
                low++;
                high--;
                
            }
        }
    }
    
    public void rotate(int[][] matrix) { 
        
        int n = matrix.length;
        
        // transpose
        for (int i = 0; i < n; i++) {
            
            for (int j = i + 1; j < n; j++) {
                
                int temp = matrix[i][j];
                
                matrix[i][j] = matrix[j][i];
                
                matrix[j][i] = temp;
                
            }
            
        }
        
        rowReverse(matrix);
        
    }       
}