import java.util.Scanner;
import java.util.Stack;

class SortedStack {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      Stack<Integer> s = new Stack<>();
      int n = sc.nextInt();
      while (n-- > 0) s.push(sc.nextInt());
      GfG g = new GfG();
      Stack<Integer> a = g.sort(s);
      while (!a.empty()) {
        System.out.print(a.peek() + " ");
        a.pop();
      }
      System.out.println();
    }
  }
} // } Driver Code Ends

/*Complete the function below*/
class GfG {

  public Stack<Integer> sort(Stack<Integer> stack) {
    //add code here.

    if (stack.isEmpty()) return stack;

    int temp = stack.pop();

    sort(stack);

    return pushBack(stack, temp);
  }

  public Stack<Integer> pushBack(Stack<Integer> stack, int temp) {
    if (stack.isEmpty() || stack.peek() <= temp) {
      stack.push(temp);
      return stack;
    }

    int ele = stack.pop();

    pushBack(stack, temp);

    stack.push(ele);
    return stack;
  }
}
