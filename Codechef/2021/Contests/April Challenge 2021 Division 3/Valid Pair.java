/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line1[] = br.readLine().trim().split(" ");
		
		int socks[] = new int[11];
		
		for (int i = 0; i < line1.length; i++){
		    
		    int color = Integer.parseInt(line1[i]);
		    socks[color]++;
		    
		}
		
		boolean sameColoredPair = false;
		
		for (int i = 1; i < socks.length; i++) {
		    
		    if (socks[i] >= 2) {
		        
		        sameColoredPair = true; 
		        break;
		        
		    }
		    
		}
		    
		if (sameColoredPair) {
		    
		    System.out.println("YES");
		    
		} else {
		    
		    System.out.println("NO");
		}
		
	}
}
