import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		
	    while(t-- >0)
	    {
	        String inputLine[] = br.readLine().trim().split(" ");
	        
	        //taking n and sum
            int n = Integer.parseInt(inputLine[0]);
            int sum = Integer.parseInt(inputLine[1]);
            
            //calling largestNumber() function
            System.out.println(new Solution().largestNumber(n, sum));
	    }
    }
}// } Driver Code Ends


class Solution
{
    // Function to return Largest Number
    static String largestNumber(int n, int sum)
    {
        // add your code here
        
        if (9 * n < sum) {
            
            return "-1";
            
        }
        
        
        int max = 9;
        String password = "";

        for (int i = 0; i < n; i++) {
        
            if (sum > 0) {
                
                max = 9;
                
                while (max > sum) {
                    
                    max--;
                    
                }
                
                password += String.valueOf(max);
                sum -= max;
                
                
                
            } else {
                
                password += "0";
                
            } 
            
        }
        
        
        return password;
        
    }
}

