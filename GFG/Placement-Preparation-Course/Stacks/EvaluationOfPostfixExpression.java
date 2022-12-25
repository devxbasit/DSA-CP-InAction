import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new Solution().evaluatePostFix(br.readLine().trim()));
		}
	}
}// } Driver Code Ends


class Solution{
    public static int evaluatePostFix(String S){
        // Your code here
        
        Stack<Integer> stack = new Stack<>();
        
        int n = S.length();
    
        char ch;
        int op1;
        int op2;
        
        for (int i = 0; i < n; i++){
            
            ch = S.charAt(i);
            
            if (ch >= 48 && ch <= 57 ){
                stack.push(Character.getNumericValue(ch));
                continue;
            }
            
            op2 = stack.pop();
            op1 = stack.pop();
                
            switch(ch){
            
                case '/':
                    stack.push(op1 / op2);
                    break;
                    
                case '*':
                    stack.push(op1 * op2);
                    break;
                    
                case '+':
                    stack.push(op1 + op2);
                    break;
                    
                case '-':
                    stack.push(op1 - op2);
                    break;
                
                
                    
            }
        }
        
        return stack.pop();
    }
}
