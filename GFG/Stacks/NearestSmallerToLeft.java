public class Solution {

  public int[] prevSmaller(int[] arr) {
    Stack<Integer> stack = new Stack<>();
    int min, n = arr.length;

    stack.push(arr[0]);
    arr[0] = -1;

    for (int i = 1; i < n; i++) {
      while (!stack.isEmpty() && stack.peek() >= arr[i]) stack.pop();

      min = stack.isEmpty() ? -1 : stack.peek();
      stack.push(arr[i]);
      arr[i] = min;
    }

    return arr;
  }
}
