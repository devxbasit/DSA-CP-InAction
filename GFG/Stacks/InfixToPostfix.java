// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().trim());
    while (t-- > 0) {
      System.out.println(new solve().infixToPostfix(br.readLine().trim()));
    }
  }
} // } Driver Code Ends

class solve {

  public static int getPrecedence(char ch) {
    switch (ch) {
      case '^':
        return 3;
      case '/':
      case '*':
        return 2;
      case '+':
      case '-':
        return 1;
    }

    // else return precedence of opening bracket "("
    // ch == '(''

    return -1;
  }

  public static String infixToPostfix(String exp) {
    // Your code here
    int n = exp.length();

    StringBuilder sb = new StringBuilder();

    Stack<Character> stack = new Stack<>();

    char ch;
    int temp;

    for (int i = 0; i < n; i++) {
      ch = exp.charAt(i);

      if (Character.isLetterOrDigit(ch)) {
        sb.append(ch);
      } else if (ch == '(') {
        stack.push(ch);
      } else if (ch == ')') {
        while (!stack.isEmpty() && stack.peek() != '(') sb.append(stack.pop());

        stack.pop();
      } else {
        temp = getPrecedence(ch);

        while (
          !stack.isEmpty() && getPrecedence(stack.peek()) >= temp
        ) sb.append(stack.pop());

        stack.push(ch);
      }
    }

    while (!stack.isEmpty()) sb.append(stack.pop());

    return sb.toString();
  }
}
