/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static boolean possible(String s, int k) {
        
        if (s.length() < k) return false;
        
        int count = 0;
        
        for (int i = 0; i < s.length(); i++){
            
            if (s.charAt(i) == '*'){
              
              count++;  
                
            } else {
                
                count = 0;
                
            }
            
            if (count >= k) return true;
            
        }
        
        return false;
        
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		
		while (T-- > 0) {
		    
		    String line1[] = br.readLine().trim().split(" ");
		    String s = br.readLine().trim();
		    
		    int k = Integer.parseInt(line1[1]);
		    
		    if (possible(s, k)) {
		        
		        System.out.println("YES");
		        
		    } else  {
		        
		        System.out.println("NO");
		        
		    }
		    
		}
		
	}
}
