// https://leetcode.com/problems/string-to-integer-atoi/
class Solution {
    public int myAtoi(String s) {
        
        int num = 0;
        int sign = 1;
        int i = 0;
        
        while (i < s.length() && s.charAt(i) == ' ') i++;
        
        
        if (i < s.length()){
            
            if (s.charAt(i) == '-') sign = -1;
            if (s.charAt(i) == '-' || s.charAt(i) == '+') i++;
            
        }
    
        
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
            
            if (num > Integer.MAX_VALUE / 10 || num == Integer.MAX_VALUE / 10 && s.charAt(i) > '7') {
                
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                
            }

            num = num * 10 + (s.charAt(i) - '0');
            System.out.println(num);
            i++;
        }
        
        return sign == -1 ? -num : num;
    }
}