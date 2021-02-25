class Solution {
    
    boolean subset(int nums[], int sum) {
        
        boolean dp[][] = new boolean[nums.length + 1][sum + 1];
        
        for (int i = 1; i < dp[0].length; i++) { 
            
            dp[0][i] = false;
            
        }
        
        for (int i = 0; i < dp.length; i++) { 
            
            dp[i][0] = true;
            
        }
        
        for (int n = 1; n < dp.length; n++) {
            
            for (int value = 1; value < dp[0].length; value++) {
                
                if (nums[n - 1] > value) {
                    
                    dp[n][value] = dp[n - 1][value];
                    
                } else {
                    
                    dp[n][value] = dp[n - 1][value - nums[n - 1]] || dp[n - 1][value]; 
                    
                }
                
            }
        }
        
        return dp[dp.length - 1][dp[0].length - 1];
        
    }
    
    
    public boolean canPartition(int[] nums) {
        
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            
            sum += nums[i];
            
        }
        
        if (sum % 2 != 0) {
            
            return false;
            
        }
        
        return subset(nums, sum / 2);
        
    }
}