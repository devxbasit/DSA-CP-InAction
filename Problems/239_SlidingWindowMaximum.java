class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        int res[] = new int [n - k + 1];
        
        Deque<Integer> deque = new LinkedList<>();
        
        int i;
        
        for (i = 0; i < k; i++){
            
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()])
                deque.removeLast();
                
            deque.addLast(i);
        }
        
        for (; i < n; i++){
            
            res[i - k] = nums[deque.peekFirst()];
            
            
            // we can replace below "while (condition) with if(condition), while just make it more generic
            
            //if (deque.peekFirst() == i - k)
            while (!deque.isEmpty() && deque.peekFirst() <= i - k)
                deque.removeFirst();
                
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()])
                deque.removeLast();
                
            deque.addLast(i);
        }
        
        res[n - k] = nums[deque.peekFirst()];
        
        return res;
    }
}