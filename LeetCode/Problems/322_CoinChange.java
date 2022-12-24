class Solution {
    
    public int coinChange(int[] coins, int amount) {
        
        int dp[] = new int[amount + 1];
        
        dp[0] = 0; 
        
        for (int i = 1; i < dp.length; i++) {
            
            dp[i] = Integer.MAX_VALUE;
            
        }
        
        for (int value = 1; value < dp.length; value++) {
            
            for (int i = 0; i < coins.length; i++) {
                
                if (coins[i] > value) continue;
                
                if (dp[value - coins[i]] == Integer.MAX_VALUE) continue;
                
                dp[value] = Math.min(dp[value], 1 + dp[value - coins[i]]);  
                
            }
        }
        
        return (dp[dp.length - 1] == Integer.MAX_VALUE) ? -1 : dp[dp.length - 1];
        
    }
}