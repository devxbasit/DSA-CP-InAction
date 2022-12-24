//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


 // } Driver Code Ends


//User function Template for Java

class CheckBit{
    
    static boolean checkKthBit(int n, int k){
        
        // Your code here
        
        // using left shift
        
        /*
        int mask = 1 << k;
        
        return ((mask & n) > 0) ? true : false;
        */
        
        
        // using right shift
        return (((n >> k) & 1) > 0) ? true : false;
    }
    
}

// { Driver Code Starts.

class CheckWhetherK_thBitIsSet
{
	static int n;
	static int k;
	
	// Driver Code
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine()); //Inputting the testcases
		
		while(t>0) //While testcases exist
		{
			
			n = Integer.parseInt(br.readLine()); //Input N
			k = Integer.parseInt(br.readLine()); // Input K
			
			CheckBit obj = new CheckBit();
			
			if(obj.checkKthBit(n, k))
				System.out.println("Yes"); //If true, print Yes
				
			else
				System.out.println("No");	// Else print No
            
            t--;
		}
		
		br.close();
	}
	
	
}  // } Driver Code Ends