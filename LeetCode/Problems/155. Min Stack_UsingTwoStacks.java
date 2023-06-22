// https://leetcode.com/problems/min-stack/

class MinStack {

  /** initialize your data structure here. */

  Stack<Integer> stack;
  Stack<Integer> minStack;

  public MinStack() {
    stack = new Stack<Integer>();
    minStack = new Stack<Integer>();
  }

  public void push(int x) {
    stack.push(x);

    if (minStack.isEmpty() || x <= minStack.peek()) {
      minStack.push(x);
    }
  }

  public void pop() {
    if (stack.isEmpty()) return;

    // dont use == to comppare
    if (stack.peek().equals(minStack.peek())) {
      minStack.pop();
    }

    stack.pop();
  }

  public int top() {
    if (stack.isEmpty()) return -1;

    return stack.peek();
  }

  public int getMin() {
    if (minStack.isEmpty()) return -1;

    return minStack.peek();
  }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
