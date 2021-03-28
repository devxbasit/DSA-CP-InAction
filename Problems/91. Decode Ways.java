class Solution {
    
    int recur(String S, int dp[], int i) {
        
        if (i >= S.length()) return 1;
        
        if (dp[i] != -1) return dp[i];
        
        if (S.charAt(i) == '0') return dp[i] = 0;
        
        if (i + 1 > S.length() - 1) {

            // can pick only one
            return dp[i] = recur(S, dp, i + 1);
            
        } else {
            
            // can pick two
            String n = "";
            n += S.charAt(i);
            n += S.charAt(i + 1);
            
            int pair = Integer.parseInt(n);
            
            if (pair <= 26) {
                
                // can pick both, one and two
                
                return dp[i] = recur(S, dp, i + 1) + recur(S, dp, i + 2);
                
            }
            
            return dp[i] = recur(S, dp, i + 1);
            
        }
        
    }

    public int numDecodings(String s) {
    
        int dp[] = new int [s.length()];
        
        for (int i = 0; i < dp.length; i++) dp[i] = -1;
        
        return recur(s, dp, 0);
        
    }
}