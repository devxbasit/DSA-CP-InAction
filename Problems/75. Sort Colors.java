class Solution {
    
    void swap(int nums[], int i, int j) {
        
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        
    }
    
    public void sortColors(int[] nums) {
        
        // counting sort 
        
//         int freq[] = new int[3];
//         int res[] = new int[nums.length];
        
//         for (int i = 0; i < nums.length; i++) {
            
//             freq[nums[i]]++;
            
//         }
        
//         for (int i = 1; i < freq.length; i++) freq[i] += freq[i - 1];
        
//         for (int i = 0; i < nums.length; i++) {
            
//             res[freq[nums[i]] - 1] = nums[i];
//             freq[nums[i]]--;
            
//         }
        
        
//         for (int i = 0; i < res.length; i++) nums[i] = res[i];
        
        
        
        
        // method 2
        
        int freq[] = new int[3];
        for (int i = 0; i < nums.length; i++) freq[nums[i]]++;
            
        
        for (int i = 0; i < nums.length; i++) {
            
            // inilized color to overcome warnings
            int color = 0;

            
            if (freq[0] > 0) {
                
                color = 0;
                
            } else if (freq[1] > 0) {
                
                color = 1;
             
            } else if (freq[2] > 0) {
                
                color = 2;
                
            }
            
            nums[i] = color;
            freq[color]--;
            
        }
        
        
        // method 3 - only one pass
        // TBD - fix it later, fails on few test cases [1,2,0]
        
//         int low = 0;
//         int high = nums.length - 1;
//         int i = 0;
        
//         while (low < high && i <= high) {
            
//             if (nums[i] == 0) {
                
//                 swap(nums, i, low);
//                 low++;
                    
//             } else if (nums[i] == 2) {
                
//                 swap(nums, i, high);
//                 high--;
                
//             }
            
//             if (nums[i] != 2)
//                 i++;
            
//         }
        
    }
}