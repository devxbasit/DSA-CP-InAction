class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        
        HashSet<Integer> set1 = new HashSet<>();
        
        for (int i = 0; i < nums1.length; i++) set1.add(nums1[i]);
        
        
        // array contian duplicate items
        // set1 = (3,7,9)
        // nums2 = [3, 3, 7, 7, 9, 9]
        
        HashSet<Integer> set2= new HashSet<>();
        
        for (int i = 0; i < nums2.length; i++) {
            
            if (set1.contains(nums2[i])) {
                
                set2.add(nums2[i]);
                
            }
        }
        
        // convert to array and return;
        
        int intersect[] = new int[set2.size()];
    
        int i = 0;
        for (int n : set2) {
            
            intersect[i++] = n;
            
        } 
        
        return intersect;
        
    }
}