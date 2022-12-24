class Solution {
    public int singleNumber(int[] nums) {
            
        HashSet<Integer> hs = new HashSet<>();
            
        int arrSum = 0;
        int uniqueElementSum = 0;
        
        
        for (int n : nums) {
            
            arrSum += n;
            
            if (!hs.contains(n)) {
                
                hs.add(n);
                uniqueElementSum += n;
                
            }
            
        }
        
        return uniqueElementSum * 2 - arrSum;
    
        
        // method 2 - use hashset, add first occurence, and remove second occurence.
        // return only remaining element in hashset
        
        // TBD - see bit manipulation approach
    }
}