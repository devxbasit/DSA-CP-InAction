//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static int knapsackRecur(int wt[], int val[], int dp[][], int n, int capacity) {
        
        if (n == 0 || capacity == 0) {
            
            return 0;
            
        }
        
        if (dp[n][capacity] != -1) {
            
            return dp[n][capacity];
            
        }
        
        if (wt[n - 1] > capacity) {
            
            return dp[n][capacity] = knapsackRecur(wt, val, dp, n - 1, capacity);
            
        }
        
        return dp[n][capacity] = Math.max(val[n - 1] + knapsackRecur(wt, val, dp, n, capacity - wt[n - 1]), 
                                                        knapsackRecur(wt, val, dp, n - 1, capacity));
                                                        
    }
    
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        
        
        int dp[][] = new int[N + 1][W + 1];
        
        for (int i = 1; i <= N; i++) {
            
            for (int j = 1; j <= W; j++) {
                
                dp[i][j] = -1;
            }
            
        }
        
        return knapsackRecur(wt, val, dp, N, W);
            
    }
}