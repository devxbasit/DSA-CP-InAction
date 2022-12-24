//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class FindFirstSetBit {
    
    
 // } Driver Code Ends





//User function Template for Java

/*  Function to find position with first set bit
*   n: input integer
*/
public static int getFirstSetBitPos(int n){
        
    // Your code here
    
    if (n == 0)
        return 0;
    
    
    int ans = ((n & n - 1) ^ n);
    /*
    the log() method in Math class calculates the log to the base 10. 
    Hence there is no direct method in Java to calculate log to the base 2.
    But as we know that, loga b = log10 b / log10 a
    */
    
    return (int)(Math.log(ans) / Math.log(2)) + 1;
}


// { Driver Code Starts.
    
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();//taking testcases
		while(t-->0){
			int n=sc.nextInt();//input n
			System.out.println(getFirstSetBitPos(n));//calling method
		}
	}
}
  // } Driver Code Ends