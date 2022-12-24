// { Driver Code Starts
//Initial Template for Java

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
		    
		    //adding coins to the array
		    for(int i=0;i<numberOfCoins;i++)
		    {
		        int x=sc.nextInt();
		        coins[i]=x;
		    }
		    
		    //creating an object of class Geeks
		    Geeks obj=new Geeks();
		    
		    //calling minimumNumberOfCoins() method of class Geeks
		    long answer=obj.minimumNumberOfCoins(coins,numberOfCoins,value);
		    
		    //printing "Not Possible" if answer is -1,
		    //else printing answer
		    System.out.println(answer==-1?"Not Possible":answer);
		}
	}
}


 // } Driver Code Ends
class Geeks
{
    //Complete this function
    public long minimumNumberOfCoins(int coins[],int numberOfCoins,int amount)
    {
        // your code here
        
         int dp[] = new int[amount + 1];

        dp[0] = 0;
        
        for (int i = 1; i < dp.length; i++) {
        
            dp[i] = Integer.MAX_VALUE;
        
        }


       for (int value = 1; value < dp.length; value++) {
            
            for (int i = 0; i < coins.length; i++) {
                
                if (coins[i] > value) continue;
                
                // we have to make sure that if we pick a coins,
                // then the remaining amount should have a valid min no of coins value
                // otherwise we will endup adding 1 to Int_MAX
                
                if (dp[value - coins[i]] == Integer.MAX_VALUE) continue;
                
                dp[value] = Math.min(dp[value], 1 + dp[value - coins[i]]);  
                
            }
        }
        
        return (dp[dp.length - 1] == Integer.MAX_VALUE) ? -1 : dp[dp.length - 1];
        
    }
}

// { Driver Code Starts.

  // } Driver Code Ends