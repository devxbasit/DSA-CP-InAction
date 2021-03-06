class Solution {
    
    void recur(List<String> al, String S, int openingBrackets, int closingBrackets) {
        
        if (openingBrackets == 0 && closingBrackets == 0)  {
            
            al.add(S);
            return;
            
        }
        
        //if we have opening bracket available, add it to string
        if (openingBrackets > 0) {
            
            recur(al, S + "(", openingBrackets - 1, closingBrackets);
            
        }
        
        // if we have not added any opening brackets yet, can we add closing bracket?
        
        if (closingBrackets > openingBrackets) {
            
            recur(al, S + ")", openingBrackets, closingBrackets - 1);
            
        }
            
    }
    
    public List<String> generateParenthesis(int n) {
        
        List<String> al = new ArrayList<String>();
        
        recur(al, "", n, n);
        
        return al;
    }
}