class Solution {
    
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> hm = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            
            hm.put(nums[i], i);
            
        }
        
        int pair[] = new int[2];
        
        for (int i = 0; i < nums.length; i++) {
            
            int diff = target - nums[i];
            
            if (hm.containsKey(diff)) {
    
                // target = 6 => ( 3 + 3) (4 + 2)
                // nums = [3, 2, 4] 
                // nums = [3, 3]
                    
                if (hm.get(diff) == i) continue;
                
                pair[0] = i;
                pair[1] = hm.get(diff);
                
                break;
           
            }
            
        }
        
        return pair;
    }
}