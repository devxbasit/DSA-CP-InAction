class Solution {

    void swap(int nums[], int i, int j) {
        
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        
    }
    
    void premutationRecur(int nums[], int start, List<List<Integer>> al) {
        
        // if we check below (start == nums.length - 1 ) then do ..
        // this condition will fail if input nums contains only 1 value
        // first time we pass start value 1
        // ==> 1 == nums.length - 1
        // ==> 1 == 0 ==> false 
        
        // to make code robust, check start >= nums.length - 1 
        if (start >= nums.length - 1) {
            
            List<Integer> temp = new ArrayList<>();
            
            for (int n : nums) {
            
                temp.add(n);
                
            }
            
            al.add(temp);
            return;
           
        }
        
        for (int i = start; i < nums.length; i++ ) {

            // do 
            swap (nums, start, i);

            // recur
            premutationRecur(nums, start + 1, al);

            // undo
            swap(nums, start, i);
            
        }

    }
    
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> al = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            
            swap(nums, 0, i);
            
            premutationRecur(nums, 1, al);
            
            swap(nums, 0, i);
            
        }
        
        return al;
    
    }
}