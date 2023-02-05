// https://leetcode.com/problems/trapping-rain-water/
class Solution {
    public int trap(int[] height) {
        
        int leftMax[] = new int[height.length];
        int rightMax[] = new int[height.length];
        
        for (int i = 1; i < height.length; i++) {
           
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
            
        }
        
        
        for (int i = height.length - 2; i >= 0; i--) {
            
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
            
        }
        
        int totalWater = 0;
        
        for (int i = 1; i < height.length - 1; i++) {
            
            int water = Math.min(leftMax[i], rightMax[i]) - height[i];
            
            if (water > 0) {
                
                totalWater+= water;
                
            }
            
        }
        
        return totalWater;
        
    }
}