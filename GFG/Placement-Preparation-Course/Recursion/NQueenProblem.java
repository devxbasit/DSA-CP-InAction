import java.lang.*;
import java.io.*;

class NQueenProblem
 {     
    static String output = "";
    
    public static void printBoard(boolean board[][]){
        int n = board.length;
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (board[i][j] == true)
                    System.out.print("1 ");
                else
                    System.out.print("0 ");
            }
            
            System.out.println("");
        }
        
        System.out.println("----------------------------------");
    }
    
    
    public static boolean isSafePlace(boolean board[][], int row, int col, int tq){
         
        // up
        for (int i = row - 1; i >= 0; i--)
            if (board[i][col] == true)
                return false;
        
        //left
        for (int i = col - 1; i >= 0; i--)
            if (board[row][col] == true)
                return false;
                
                
        // up - left
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == true)
                return false;
        
        
        // up - right
        for (int i = row - 1, j = col + 1; i >= 0 && j < tq; i--, j++)
            if (board[i][j] == true)
                return false;
        
        return true;
    }
    
    public static void NQueen(boolean board[][], int row, int col, int tq, int tqpsf, String res){
        
        if (tqpsf == tq){
            output += "[" + res + "] ";
            return;
        }
        
        if (row == tq)
            return;
            
            
        for (int i = col; i < tq; i++){
            
            if (isSafePlace(board, row, i, tq)){
                
                //do
                board[row][i] = true;
                
                //recur
                NQueen(board, row + 1, 0, tq, tqpsf + 1, res + String.valueOf(i + 1) + " ");
                
                //undo
                board[row][i] = false;
            }
        }
    }
    
	public static void main (String[] args) throws IOException
	 {
	    //code
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int T = Integer.parseInt(br.readLine().trim());
	    
	    while (T-- > 0){
	        
	        int n = Integer.parseInt(br.readLine().trim());
	        
	        if (n == 1){
	            System.out.println("[1 ]");
	            
	        } else if (n == 2 || n == 3) {
	            System.out.println("-1");
	            
	        } else {
	            boolean board[][] = new boolean[n][n];
    	        output = "";
    	        
    	        NQueen(board, 0, 0, n, 0, "");
    	       
    	        System.out.println(output);
	        }
    	        
	    }
	    
	 }
}