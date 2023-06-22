import java.lang.*;
import java.util.*;

class MaxRect {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int m = sc.nextInt();
      int n = sc.nextInt();
      int[][] a = new int[1000][1000];
      for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) a[i][j] =
        sc.nextInt();
      GfG g = new GfG();

      System.out.println(g.maxArea(a, m, n));
    }
  }
}

// } Driver Code Ends

/*Complete the function given below*/
class GfG {

  public static void nearestSmallerLeft(int hist[], int left[], int n) {
    Stack<Integer> stack = new Stack<>();

    left[0] = -1;
    stack.push(0);

    for (int i = 1; i < n; i++) {
      while (!stack.isEmpty() && hist[stack.peek()] >= hist[i]) stack.pop();

      left[i] = stack.isEmpty() ? -1 : stack.peek();

      stack.push(i);
    }
  }

  public static void nearestSmallerRight(int hist[], int right[], int n) {
    Stack<Integer> stack = new Stack<>();

    right[n - 1] = n;
    stack.push(n - 1);

    for (int i = n - 2; i >= 0; i--) {
      while (!stack.isEmpty() && hist[stack.peek()] >= hist[i]) stack.pop();

      right[i] = stack.isEmpty() ? n : stack.peek();

      stack.push(i);
    }
  }

  public static int getMaxHistogramArea(int hist[], int n) {
    // your code here

    int left[] = new int[n];
    int right[] = new int[n];

    nearestSmallerLeft(hist, left, n);
    nearestSmallerRight(hist, right, n);

    int max = 0;
    int area;

    for (int i = 0; i < n; i++) {
      area = (right[i] - left[i] - 1) * hist[i];

      max = (area > max) ? area : max;
    }

    return max;
  }

  public int maxArea(int M[][], int m, int n) {
    // add code here.

    for (int row = 1; row < m; row++) for (
      int col = 0;
      col < n;
      col++
    ) M[row][col] = (M[row][col] == 0) ? 0 : M[row][col] + M[row - 1][col];

    int max = 0;
    int area;

    for (int histogram = 0; histogram < m; histogram++) {
      area = getMaxHistogramArea(M[histogram], n);
      max = (area > max) ? area : max;
    }

    return max;
  }
}
