import java.io.*;
import java.util.*;

class DeterminantOfMatrix {

  public static void main(String args[]) throws IOException {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while (t-- > 0) {
      int n = sc.nextInt();
      int matrix[][] = new int[n][n];

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) matrix[i][j] = sc.nextInt();
      }
      Solution ob = new Solution();
      System.out.println(ob.determinantOfMatrix(matrix, n));
    }
  }
} // } Driver Code Ends

class Solution {

  public static void getCofactors(
    int matrix[][],
    int n,
    int index,
    int cofactors[][]
  ) {
    int i = 0;
    int j = 0;

    for (int row = 0; row < n; row++) for (int col = 0; col < n; col++) {
      if (row != 0 && col != index) {
        cofactors[i][j] = matrix[row][col];

        j++;

        // cofactor lenght = n - 1
        if (j == n - 1) {
          j = 0;
          i++;
        }
      }
    }
  }

  static int determinantOfMatrix(int matrix[][], int n) {
    // code here
    if (n == 1) return matrix[0][0];

    int D = 0;
    int sign = 1;

    int cofactors[][] = new int[n - 1][n - 1];

    for (int i = 0; i < n; i++) {
      if (matrix[0][i] != 0) {
        getCofactors(matrix, n, i, cofactors);
        D += sign * matrix[0][i] * determinantOfMatrix(cofactors, n - 1);
      }

      sign *= -1;
    }

    return D;
  }
}
