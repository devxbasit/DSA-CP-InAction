//https://practice.geeksforgeeks.org/problems/subarray-with-0-sum-1587115621/1

class Solution{
    //Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int nums[],int n)
    {
        //Your code here
        
        int[] prefixSum = new int[nums.length];
        
        prefixSum[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            
            prefixSum[i] = prefixSum[i - 1] + nums[i];
           
        }
        
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < prefixSum.length; i++)  {
            
            // if at i point sum = x and at j point sum = 0, that means sub array sum 0 exists
            if (prefixSum[i] == 0 || set.contains(prefixSum[i])) return true;
            
            set.add(prefixSum[i]);
        }
        
        return false;
    }
}