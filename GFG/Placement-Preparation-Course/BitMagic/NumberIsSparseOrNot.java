//Initial Template for Java

import java.io.*;
import java.util.*;


 // } Driver Code Ends


//User function Template for Java


class Sparse{
    
    // Function to check if the given number is sparse or not
    public static boolean isSparse(int n){
        
        // Your code here
        return ( (n & (n >> 1)) == 0) ? true : false; 
        
    }
    
}


// { Driver Code Starts.

class NumberIsSparseOrNot {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//testcases
		int t = sc.nextInt();
		
		while(t-->0){
		    
		    		     
            //initializing n
		    int n = sc.nextInt();
		    
		    Sparse obj = new Sparse();
		    
		    //printing 1 if isSparse returns true
            //else 0
		    if(obj.isSparse(n)){
		        System.out.println("1");
		    } else {
                System.out.println("0");
		    }
		}
	}
} 
// } Driver Code Ends



