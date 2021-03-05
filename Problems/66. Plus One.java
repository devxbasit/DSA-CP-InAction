class Solution {
    
    public int[] plusOne(int[] digits) {
        
        boolean flag = true;
        
        for (int i = digits.length - 1; i >= 0; i--) {
        
            if (digits[i] == 9) {
                
                digits[i] = 0;
                continue;
                
            }
         
            // unset flag because digits are not in series 99, 999, 999, 99999 
            flag = false;
            
            digits[i] = digits[i] + 1;
            break;
            
        }
        
        
        if (flag) {
            
            int n[] = new int[digits.length + 1];
            n[0] = 1;
            
            for (int i = 1; i < n.length; i++) {
                
                n[i] = digits[i - 1];
                
            } 
            
            return n;
            
        }
        
        return digits;
        
    }
}