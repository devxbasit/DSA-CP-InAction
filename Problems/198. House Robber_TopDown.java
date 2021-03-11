class Solution {
    
    int recur(int nums[], int dp[], int n) {
        
        if (n == 0) return dp[n] = nums[n];
        
        if (n == 1) return dp[n] = Math.max(nums[0], nums[1]);
        
        if (dp[n] != -1) return dp[n];
        
        return dp[n] = Math.max(recur(nums, dp, n - 1), nums[n] + recur(nums, dp, n - 2));
        
    }
    
    public int rob(int[] nums) {
        
        int dp[] = new int[nums.length];
        
        for (int i = 0; i < dp.length; i++) dp[i] = -1;
        
        return recur(nums, dp, nums.length - 1);
        
    }
}