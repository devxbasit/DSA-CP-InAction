//Initial Template for Java

import java.io.*;
import java.util.*;

class RotateBy90Degree
{
    public static void main(String args[])throws IOException
    {
         BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            int matrix[][] = new int[n][n];
            String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(st[k++]);
            }
            Solution ob = new Solution();
            ob.rotateby90(matrix, n);
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                    System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static void rotateby90(int matrix[][], int n) 
    { 
        // code here
        
        int temp;
        
        // transpose matrix
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
            
                
        // reverse col. wise
        
        for (int col = 0; col < n; col++){
            
            int start = 0;
            int end = n - 1;
            
            while (start < end){
                temp = matrix[start][col];
                matrix[start][col] = matrix[end][col];
                matrix[end][col] = temp;
                
                start++;
                end--;
            }
        }
    }
}
