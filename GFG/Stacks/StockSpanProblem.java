import java.io.*;
import java.lang.*;
import java.util.*;

class gfg {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while (t-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];

      int i = 0;
      for (i = 0; i < n; i++) a[i] = sc.nextInt();

      int[] s = new solve().calculateSpan(a, n);

      for (i = 0; i < n; i++) {
        System.out.print(s[i] + " ");
      }

      System.out.println();
    }
  }
} // } Driver Code Ends

class solve {

  // Function to calculate span
  // price[]: input array
  public static int[] calculateSpan(int price[], int n) {
    // Your code here

    Stack<Integer> stack = new Stack<>();
    int span[] = new int[n];
    int pr;

    span[0] = 1;
    stack.push(0);

    for (int i = 1; i < n; i++) {
      pr = price[i];
      while (!stack.isEmpty() && price[stack.peek()] <= price[i]) stack.pop();

      span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();

      stack.push(i);
    }

    return span;
  }
}
