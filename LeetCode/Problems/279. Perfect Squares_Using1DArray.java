class Solution {
    
    public int numSquares(int n) {
        
        List<Integer> al = new ArrayList<>();
        
        int i = 1;
        
        while ( i * i <= n) {
            
            al.add(i * i);
            i++;
            
        }
        
        int dp[] = new int[n + 1];
        
        for (i = 0; i < dp.length; i++) dp[i] = Integer.MAX_VALUE;
        
        dp[0] = 0;
        
        // same as coin change problem - min no. of coins
        
        for (i = 0; i < al.size(); i++) {
            
            for (int j = al.get(i); j < dp.length; j++) {
                
                if (dp[j - al.get(i)] == Integer.MAX_VALUE) continue;
                
                dp[j] = Math.min(1 + dp[j - al.get(i)], dp[j]);
                     
            }
        }
        
        return dp[dp.length - 1];
    }
       
}