import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().trim());
    while (t-- > 0) {
      long n = Long.parseLong(br.readLine().trim());
      String inputLine[] = br.readLine().trim().split(" ");
      long[] arr = new long[(int) n];
      for (int i = 0; i < n; i++) arr[i] = Long.parseLong(inputLine[i]);
      System.out.println(new solve().getMaxArea(arr, n));
    }
  }
}

// } Driver Code Ends

class solve {

  // Function to calculate max rectangular area histogram
  // hist[]: input array
  // n: size of array
  public static void nearestSmallerLeft(long hist[], int left[], int n) {
    Stack<Integer> stack = new Stack<>();

    left[0] = -1;
    stack.push(0);

    for (int i = 1; i < n; i++) {
      while (!stack.isEmpty() && hist[stack.peek()] >= hist[i]) stack.pop();

      left[i] = stack.isEmpty() ? -1 : stack.peek();

      stack.push(i);
    }
  }

  public static void nearestSmallerRight(long hist[], int right[], int n) {
    Stack<Integer> stack = new Stack<>();

    right[n - 1] = n;
    stack.push(n - 1);

    for (int i = n - 2; i >= 0; i--) {
      while (!stack.isEmpty() && hist[stack.peek()] >= hist[i]) stack.pop();

      right[i] = stack.isEmpty() ? n : stack.peek();

      stack.push(i);
    }
  }

  public static long getMaxArea(long hist[], long n) {
    // your code here

    int left[] = new int[(int) n];
    int right[] = new int[(int) n];

    nearestSmallerLeft(hist, left, (int) n);
    nearestSmallerRight(hist, right, (int) n);

    long max = 0;
    long area;

    for (int i = 0; i < n; i++) {
      area = (right[i] - left[i] - 1) * hist[i];

      max = (area > max) ? area : max;
    }

    return max;
  }
}
