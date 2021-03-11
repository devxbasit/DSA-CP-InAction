class Solution {
    
    void dfsRecur(String S[], List<String> al, int n, String str) {
        
        if (n >= S.length ) {
          
            al.add(str);
            return;
            
        }
        
        for (int i = 0; i < S[n].length(); i++) {
            
            dfsRecur(S, al, n + 1, str + S[n].charAt(i));
            
        }
    
    }
    
    
    public List<String> letterCombinations(String digits) {
        
        String S[] = new String[digits.length()];
        
        List<String> al = new ArrayList<>();
        
        if (digits.length() == 0) return al;
        
        for (int i = 0; i < digits.length(); i++) {
            
            switch (digits.charAt(i)) {
                    
                case '2' :
                    S[i] = "abc";
                    break;
                    
                case '3' :
                    S[i] = "def";
                    break;
                    
                case '4' :
                    S[i] = "ghi";
                    break;
                    
                case '5' :
                    S[i] = "jkl";
                    break;
                    
                case '6' :
                    S[i] = "mno";
                    break;
                    
                case '7' :
                    S[i] = "pqrs";
                    break;
                    
                case '8' :
                    S[i] = "tuv";
                    break;
                    
                case '9' :
                    S[i] = "wxyz";
                    break;
                    
            }

        }
        
        dfsRecur(S, al, 0, "");
        
        return al;
        
    }
}