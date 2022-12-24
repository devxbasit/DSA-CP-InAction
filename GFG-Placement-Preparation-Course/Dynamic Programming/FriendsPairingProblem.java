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
                    Solution ob = new Solution();
                    System.out.println(ob.countFriendsPairings(n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java
class Solution
 {

    public long countFriendsPairings(int n ) 
    { 
       //code here
       
       if (n == 0) return 0;
       if (n == 1) return 1;
       if (n == 2) return 2;
       
       long dp[] = new long[n + 1];
       
       int M = 1000000007;
       
       dp[1] = 1; 
       dp[2] = 2;
       
       for (int i = 3; i < dp.length; i++) {
           
           dp[i] = (dp[i - 1]  + ((i - 1) * dp[i - 2]) % M) % M;
           
       }
       
       return dp[n];
       
    }
}    
 