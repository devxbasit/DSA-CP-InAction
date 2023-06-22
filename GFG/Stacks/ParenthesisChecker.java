import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    //Reading total number of testcases
    int t = sc.nextInt();

    while (t-- > 0) {
      //reading the string
      String st = sc.next();

      //calling ispar method of Paranthesis class
      //and printing "balanced" if it returns true
      //else printing "not balanced"
      if (new Parenthesis().ispar(st) == true) System.out.println(
        "balanced"
      ); else System.out.println("not balanced");
    }
  }
} // } Driver Code Ends

class Parenthesis {

  // Function to return if the paranthesis are balanced or not
  static boolean ispar(String x) {
    // add your code here

    Stack<Character> stack = new Stack<>();

    int n = x.length();
    char ch;

    char opening;

    for (int i = 0; i < n; i++) {
      ch = x.charAt(i);

      if (ch == '(' || ch == '{' || ch == '[') {
        stack.push(ch);
        continue;
      }

      if (stack.isEmpty()) return false;

      switch (ch) {
        case ')':
          opening = '(';
          break;
        case '}':
          opening = '{';
          break;
        case ']':
          opening = '[';
          break;
        default:
          return false;
      }

      if (opening != stack.pop()) return false;
    }

    return stack.isEmpty();
  }
}
