public class Solution {

  public int[] prevSmaller(int[] arr) {
    Stack<Integer> stack = new Stack<>();
    int min, n = arr.length;

    stack.push(arr[n - 1]);
    arr[n - 1] = -1;

    for (int i = n - 2; i >= 0; i--) {
      while (!stack.isEmpty() && stack.peek() >= arr[i]) stack.pop();

      min = stack.isEmpty() ? -1 : stack.peek();
      stack.push(arr[i]);
      arr[i] = min;
    }

    return arr;
  }
}
