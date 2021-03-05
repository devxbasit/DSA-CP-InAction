class Solution {
    
    char getMapping(char ch) {
        
        if (ch == '[') return ']';        
        if (ch == '{') return '}';        
        if (ch == '(') return ')';        
        
        return '-';
    }
    
    public boolean isValid(String s) {
    
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            
            if (s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(') {
                
                stack.push(s.charAt(i));
                continue;
                
            }
            
            if (stack.isEmpty()) return false;
            
            char ch = getMapping(stack.pop());
            
            if (ch != s.charAt(i)) return false;
            
        }
        
        return stack.isEmpty();
    }
}