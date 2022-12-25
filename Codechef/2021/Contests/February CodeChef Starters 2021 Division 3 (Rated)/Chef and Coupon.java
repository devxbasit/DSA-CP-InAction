/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    // https://www.codechef.com/START1C/problems/COUPON2
    
    public static boolean buy(int A, int B, int D, int C) {
        
        int total = A + B + C;
        
        if (A < 150) total += D;
        
        if (B < 150) total += D;
        
        return total < A + B + (2 * D);    
        
    }
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	    int T = Integer.parseInt(br.readLine().trim());
	    
	    while (T-- > 0) {
	        
	        String line0[] = br.readLine().trim().split(" ");
	        
	        int D = Integer.parseInt(line0[0]);
	        int C = Integer.parseInt(line0[1]);
	        
	        String line1[] = br.readLine().trim().split(" ");
	        String line2[] = br.readLine().trim().split(" ");
	        
	        int A = 0;
	        int B = 0;
	        
	        for (String s : line1) {
	            
	            A = A + Integer.parseInt(s); 
	            
	        }
	        
	        for (String s : line2) {
	            
	            B = B + Integer.parseInt(s);
	            
	        }
	        
	        
	        if (buy(A, B, D, C)) {
	            
	            System.out.println("YES");
	            
	        } else { 
	            
	            System.out.println("NO");
	            
	        }
	    }
	}
}
