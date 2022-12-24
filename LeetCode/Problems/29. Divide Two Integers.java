class Solution {
    public int divide(int dividend, int divisor) {
        
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        
        
        int sign = 1;

        if (dividend < 0 && divisor > 0) sign = -1;
        if (dividend > 0 && divisor < 0) sign = -1;
        
        // else both -ve or +ve, sign will be +ve
        
        
        int res = 0;
            
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
    
        while (dividend - divisor >= 0) {
            
            int i = 0;
            
            while (dividend - (divisor << 1 << i) >= 0) {
                
                i++;
                    
            }
            
            res += 1 << i;
            
            dividend = dividend - (divisor << i);
            
        }
        
        return res * sign;
        
    }
}