class Solution {
    public int change(int amount, int[] coins) {
        
           
        int dp[][] = new int[coins.length + 1][amount + 1];
        
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