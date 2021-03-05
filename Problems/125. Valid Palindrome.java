class Solution {
    public boolean isPalindrome(String s) {
        
        int i = 0;
        int j = s.length() - 1;
        
        while (i <= j) {
            
            while ((i < s.length()) &&
                   !(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') &&
                    !(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') &&
                    !(s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                
                   i++;
                
            }
                   
                   
           while ((j >= 0) &&
                  !(s.charAt(j) >= 'a' && s.charAt(j) <= 'z') &&
                    !(s.charAt(j) >= 'A' && s.charAt(j) <= 'Z') &&
                    !(s.charAt(j) >= '0' && s.charAt(j) <= '9')) {
               
                j--;
               
           }
            
            
            if (i > j) {
                
                return true;
                
            } 
            
            
            char a = Character.toLowerCase(s.charAt(i));
            char b = Character.toLowerCase(s.charAt(j));
            
            // return false if and if only a != b, else ture always
            if (a != b) return false;
            
            i++;
            j--;
            
        }
        
        return true;
        
    }
}