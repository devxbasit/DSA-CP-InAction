class Solution {

    public boolean canJump(int[] nums) {
        
        // see also method 1  - using dp
        
        int reachability = 0;
        
        for (int i = 0; i < nums.length; i++) {
            
            if (reachability < i) return false;
            
            reachability = Math.max(reachability, i + nums[i]);
            
            if (reachability >= nums.length - 1) return true; 
            
        }
        
        return true;
            
    }
}