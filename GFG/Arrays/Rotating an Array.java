// https://practice.geeksforgeeks.org/problems/reversal-algorithm5340/1

class Solution {
    void leftRotate(int[] nums, int n, int d) {
        // code here
        
         d = d % nums.length;
        
        if (d == 0) return;
        
        reverse(nums, 0, d - 1);
        reverse(nums, d, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
        
    }
    public void reverse(int[] nums, int low, int high) {
        
        while(low < high) {
            
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
        
            low++; 
            high--;
        }
        
    }
}
