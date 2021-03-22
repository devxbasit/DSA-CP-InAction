/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{

//  https://www.codechef.com/problems/COLGLF2   
    public static long calculate(String line[], int Q[], int x) {
        
        int episodes = Integer.parseInt(line[0]);
        
        long sum = 0;
        
        for (int i = 1; i < line.length; i++) {
            
            if (i == 1) {
                
                sum += Integer.parseInt(line[i]);
                
            } else {
                
                sum = sum + Integer.parseInt(line[i]) - Q[x];
                
            }
        }
        
        return sum;
        
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
            
        while (T-- > 0) {
        
            int S = Integer.parseInt(br.readLine().trim());
            
            String line1[] = br.readLine().trim().split(" ");
            
            int Q[] = new int[line1.length];
            
            for (int i = 0; i < line1.length; i++) {
                
                Q[i] = Integer.parseInt(line1[i]);
                
            }
            
            long total = 0;
            
            for (int i = 0; i < S; i++) {
                
                line1 = br.readLine().trim().split(" ");
                
                total += calculate(line1, Q, i);
              
                
            }
            
            System.out.println(total);
        
        }
	}
}