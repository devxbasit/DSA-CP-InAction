// { Driver Code Starts
//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total count of testcases
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    //taking total number of elements
		    int n=sc.nextInt();
		    
		    //calling printFibb() method
		    long[] res = printFibb(n);
		    
		    //printing the elements of the array
		    for (int i = 0; i < res.length; i++)
		        System.out.print (res[i]+" ");
		    System.out.println();
		}
	}
	

 // } Driver Code Ends


//User function Template for Java

public static long[] printFibb(int n) 
{
    
    // Your code here
    
    long fib[] = new long[n];
    
    
    fib[0] = 1;
    if (n == 1) {
        
        return new long[] {fib[0]} ;
        
    }
    
    
    fib[1] = 1;
    if (n == 2) {
        
        return new long[] {fib[0], fib[1]} ;
        
    }

    
    for (int i = 2; i < n; i++) {
        
        fib[i] = fib[i - 1] + fib[i - 2];

    }

    return fib;

}


// { Driver Code Starts.

}  // } Driver Code Ends