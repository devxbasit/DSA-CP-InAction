class Solution {
    
    public String countAndSay(int n) {
        
        if (n == 1) return "1";
        
        String S = "1";
        String next = "";
        n--;
        
        
        while (n-- > 0) {
            
            int count = 0;
        
            for (int i = 0; i < S.length(); i++) {
                
                count++;
                
                if (i < S.length() - 1 && S.charAt(i) == S.charAt(i + 1)) {
                    
                    continue;
                    
                }
                
                
                next += String.valueOf(count) + S.charAt(i);
                count = 0;
                
            }
            
            S = next;
            next = "";
            
        }
        
        return S;
        
    }
        
        
}