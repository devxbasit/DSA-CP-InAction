class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {        

        Map<Integer, Integer> freq = new HashMap<>();
        
        for (int i = 0; i < nums1.length; i++) {
            
            freq.put(nums1[i], freq.getOrDefault(nums1[i], 0) + 1);
            
        }
        
        
        // array contian duplicate items
        
        ArrayList<Integer> al = new ArrayList<>();
        
        for (int i = 0; i < nums2.length; i++) {
            
            if (freq.containsKey(nums2[i])) {
                
                int f = freq.get(nums2[i]);
                
                al.add(nums2[i]);
                
                if (f == 1) {
                    
                    freq.remove(nums2[i]);
                    continue;
                    
                }
                
                
                f--;
                freq.put(nums2[i], f);
                
            }
        }
        
    
        // convert to array and return
        
        int intersect[] = new int[al.size()];
    
        
        
        for (int i = 0; i < al.size(); i++) {
            
            intersect[i] = al.get(i);
            
        } 
        
        return intersect;
        
    }
}