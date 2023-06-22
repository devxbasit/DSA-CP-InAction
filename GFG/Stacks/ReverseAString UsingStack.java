/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      Solution obj = new Solution();
      System.out.println(obj.reverse(sc.next()));
    }
  }
}

// } Driver Code Ends

class Solution {

  public String reverse(String S) {
    //code here

    Stack<Character> stack = new Stack<>();

    int n = S.length();

    for (int i = 0; i < n; i++) stack.push(S.charAt(i));

    StringBuilder sb = new StringBuilder();

    while (!stack.isEmpty()) sb.append(stack.pop());

    return sb.toString();
  }
}
