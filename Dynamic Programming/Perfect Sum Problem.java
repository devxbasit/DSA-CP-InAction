// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    // } Driver Code Ends


class Solution{

	public int perfectSum(int nums[], int nn, int S) 
	{ 
	    // Your code goes here
	    
	    int MOD = 1000000007;
	    int dp[][] = new int[nums.length + 1][S + 1];
        
        for (int i = 0; i < dp.length; i++)  dp[i][0] = 1;
        for (int j = 1; j < dp[0].length; j++)  dp[0][j] = 0;
    
        for (int n = 1; n < dp.length; n++) {
            
            for (int sum = 1; sum < dp[0].length; sum++) {
                 
                if (nums[n - 1] > sum) {
                    
                    dp[n][sum] = dp[n - 1][sum];
                    
                } else {
                    
                    dp[n][sum] = ((dp[n - 1][sum - nums[n - 1]]) % MOD + (dp[n - 1][sum]) % MOD) % MOD; 
                    
                }
            }
        }
        
        return dp[dp.length - 1][dp[0].length - 1]; 
	} 
}