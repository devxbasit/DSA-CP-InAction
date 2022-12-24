class Solution {
    
    public int numSquares(int n) {
        
        List<Integer> al = new ArrayList<>();
        
        int i = 1;
        
        while ( i * i <= n) {
            
            al.add(i * i);
            i++;
            
        }
        
        int dp[][] = new int[al.size() + 1][n + 1];
        
        for (i = 0; i < dp[0].length; i++) dp[0][i] = Integer.MAX_VALUE;
        
        for (i = 0; i < dp.length; i++) dp[i][0] = 0;
        
        // same as coin change problem - min no. of coins
        
        for (i = 1; i < dp.length; i++) {
            
            for (int j = 1; j < dp[0].length; j++) {
                
                if (al.get(i - 1) > j) {
                  
                    dp[i][j] = dp[i - 1][j];
                    continue;
                    
                }
                
                if (dp[i][j - al.get(i - 1)] == Integer.MAX_VALUE) {
                    
                    dp[i][j] = Integer.MAX_VALUE;
                    continue;
                    
                }
                
                dp[i][j] = Math.min(1 + dp[i][j - al.get(i - 1)], dp[i - 1][j]);
                     
            }
        }
        
        return dp[dp.length - 1][dp[0].length - 1];
    }
       
}