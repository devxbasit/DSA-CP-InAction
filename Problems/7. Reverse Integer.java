class Solution {
    
    // https://www.youtube.com/watch?v=1bfbV4jx0To&ab_channel=CodingwithConner
    
    public int reverse(int x) {
        
        int prev = 0;
        int reverse = 0;
        int rem = 0;
        
        while (x != 0) {

            prev = reverse;
            
            rem = x % 10;
            x /= 10;
            
            reverse = reverse * 10 + rem;
            
            if ((reverse - rem) / 10 != prev) return 0;
            

        }
        
        return reverse;
        
    }
}