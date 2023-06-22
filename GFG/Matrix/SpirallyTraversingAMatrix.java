import java.io.*;
import java.util.*;

class SpirallyTraversingAMatrix {

  public static void main(String args[]) throws IOException {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while (t-- > 0) {
      int r = sc.nextInt();
      int c = sc.nextInt();

      int matrix[][] = new int[r][c];

      for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) matrix[i][j] = sc.nextInt();
      }
      Solution ob = new Solution();
      ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
      for (Integer val : ans) System.out.print(val + " ");
      System.out.println();
    }
  }
} // } Driver Code Ends

class Solution {

  static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c) {
    // code here
    ArrayList<Integer> al = new ArrayList<>();

    int top, bottom, left, right;

    top = 0;
    right = matrix[0].length - 1;
    bottom = matrix.length - 1;
    left = 0;

    int size = r * c;

    while (al.size() < size) {
      for (int i = left; i <= right && al.size() < size; i++) al.add(
        matrix[top][i]
      );
      top++;

      for (int i = top; i <= bottom && al.size() < size; i++) al.add(
        matrix[i][right]
      );
      right--;

      for (int i = right; i >= left && al.size() < size; i--) al.add(
        matrix[bottom][i]
      );
      bottom--;

      for (int i = bottom; i >= top && al.size() < size; i--) al.add(
        matrix[i][left]
      );
      left++;
    }

    return al;
  }
}
