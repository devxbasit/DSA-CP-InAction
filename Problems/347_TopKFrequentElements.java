class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        int n = nums.length;
	    HashMap<Integer, Integer> hm = new HashMap<>();
	    
	    for (int i : nums)
	        hm.put(i, hm.getOrDefault(i, 0) + 1);
	   
	    
	    PriorityQueue<Map.Entry<Integer, Integer>> pque = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>(){
	        
	        public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2){
	            
	            // if frequence is same
	            if (e1.getValue() == e2.getValue())
	                return e2.getKey() - e1.getKey();
	                
	           return e2.getValue() - e1.getValue();
	        }
	        
	    });
	        
	    for (Map.Entry<Integer, Integer> entry : hm.entrySet())
	        pque.add(entry);
	       
	    int res[] = new int[k];
	    
	    for (int i = 0; i < k; i++)
	        res[i] = pque.remove().getKey();
	  
	    return res;
    }
}