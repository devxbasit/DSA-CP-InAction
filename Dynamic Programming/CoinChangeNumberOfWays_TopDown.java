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
		int testcases=sc.nextInt();
		while(testcases-->0)
		{
		    //taking value
		    int value=sc.nextInt();
		    
		    //taking number of coins
		    int numberOfCoins=sc.nextInt();
		    int coins[]=new int[numberOfCoins];
		    
		    //inserting coins to the array
		    for(int i=0;i<numberOfCoins;i++)
		    {
		        int x=sc.nextInt();
		        coins[i]=x;
		    }
		    
		    //creating an object of class Geeks
		    Geeks obj=new Geeks();
		    
		    //calling method numberOfWays() of class Geeks
		    System.out.println(obj.numberOfWays(coins,numberOfCoins,value));
		}
	}
}



 // } Driver Code Ends


//User function Template for Java
                                                            

class Geeks
{

    //Complete this function
    public long numberOfWays(int coins[],int numberOfCoins,int amount)
    {
        
        int dp[][] = new int[numberOfCoins + 1][amount +1];
        
        for (int i = 1; i < dp[0].length; i++) {
            
            dp[0][i] = 0;
            
        }
        
        for (int i = 0; i < dp.length; i++) {
            
            dp[i][0] = 1;
            
        }
        
        for (int n = 1; n < dp.length; n++) {
    
            for (int value = 1; value < dp[0].length; value++) {
                    
                if (coins[n - 1] > value) {
                    
                    dp[n][value] = dp[n - 1][value];
                       
                }else {
                    
                    dp[n][value] = dp[n][value - coins[n - 1]] + dp[n - 1][value];
                    
                }
            }
        }
        
        return dp[dp.length - 1][dp[0].length - 1];
    }
    
    
}

// { Driver Code Starts.

  // } Driver Code Ends