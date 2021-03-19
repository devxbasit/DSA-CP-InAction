class Solution {
    
    boolean jump(int nums[], int dp[], int i) {
        
        if (i == nums.length - 1) {
            
            dp[i] = 1;
            return true;
            
        } 
        
        if (nums[i] == 0) {
            
            dp[i] = 0;
            return false;
            
        }
        
        if (dp[i] != -1) {
          
            return dp[i] == 1;
            
        }  
        
        for (int j = 1; j <= nums[i] && (i + j) < nums.length; j++) {
        
            if (jump(nums, dp, i + j)) {
                
                dp[i] = 1;
                return true;
                
            }
            
        }
        
        dp[i] = 0;
        return false;
        
    }
    
    public boolean canJump(int[] nums) {
        
        int dp[] = new int[nums.length];
        
        for (int i = 0; i < dp.length; i++) dp[i] = -1;
        
        return jump(nums, dp, 0);
        
    }
}