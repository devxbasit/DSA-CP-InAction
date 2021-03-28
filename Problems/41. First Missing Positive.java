class Solution {
    public int firstMissingPositive(int[] nums) {
        
        // method 1
//         Arrays.sort(nums);
        
//         int i = 0;
        
//         while (i < nums.length && nums[i] <= 0) i++;
        
//         int n = 1;
        
//         while (i < nums.length) {
            
//             if (i > 0 && nums[i] == nums[i - 1]) {
                
//                 i++;
//                 continue;
                
//             }
            
//             if (nums[i] != n) return n;
            
//             n++;
//             i++;
//         }
        
        
//         return n;
        
        // method 2 - use set
        
        
        boolean oneIsPresent = false;
        
        for (int i = 0; i < nums.length; i++) {
            
            if (nums[i] == 1) {
                
                oneIsPresent = true;
                continue;
                
            }
            
            if (nums[i] <= 0) {
                
                nums[i] = 1;
                
            }
            
        }
        
        if (!oneIsPresent) return 1;
        
        for (int i = 0; i < nums.length; i++) {
            
            int index = Math.abs(nums[i]) - 1;
            
            if (index >= nums.length) continue;
            
            if (nums[index] < 0) continue;
            
            nums[index] = nums[index] * -1;
            
        }
        
        for (int i = 0; i < nums.length; i++) {
            
            if (nums[i] > 0) return i + 1;
            
        }
        
        return nums.length + 1;
    }
}