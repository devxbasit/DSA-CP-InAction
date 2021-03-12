class Solution {
    
    int calculate(int b, int a, String op) {
        
        switch (op) {
                
            case "*" :
                
                return a * b;
                
                
            case "/" :
                
                return a / b;
              
                
            case "+" :
                
                return a + b;
              
                
            case  "-" :
                
                return a - b;
              
    
        }
        
        return a + b;
        
    }
    
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < tokens.length; i++) {
            
            if (tokens[i].equals("*") || tokens[i].equals("/") ||tokens[i].equals("+") || tokens[i].equals("-")) {
                
                stack.push(calculate(stack.pop(), stack.pop(), tokens[i]));
                continue;
                
            }
            
            stack.push(Integer.parseInt(tokens[i]));
            
        }
        
        return stack.pop();
        
    }
}