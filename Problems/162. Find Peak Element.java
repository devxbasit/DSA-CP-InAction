class Solution {
    
    int binarySearch(int nums[], int low, int high) {
        
        if (low >= high) return low;
        
        int mid = low + (high - low)  / 2;
        
        if (mid != 0 && nums[mid] > nums[mid - 1]  &&
                mid != nums.length - 1 && nums[mid] > nums[mid + 1]) return mid;
        
         
        return nums[mid + 1] > nums[mid] ? binarySearch(nums, mid + 1, high) : 
                                            binarySearch(nums, low, mid - 1);
        
        
    }
    
    public int findPeakElement(int[] nums) {
        
        if (nums.length == 1) return 0;
        
        return binarySearch(nums, 0, nums.length - 1);

        // simple iterative solution
        // if (nums.length == 1) return 0;
        
        // int peak = 0;
        
        // for (int i = 0; i < nums.length - 1; i++)  {
            
        //     if(nums[i] > nums[i + 1]) return i;
            
        // }                

        // return nums.length - 1;
    }
}