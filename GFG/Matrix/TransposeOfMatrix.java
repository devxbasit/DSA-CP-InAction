//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class TransposeOfMatrix {

  public static void main(String[] args) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(read.readLine());

    while (t-- > 0) {
      int n = Integer.parseInt(read.readLine());
      int a[][] = new int[n][n];
      String st[] = read.readLine().trim().split("\\s+");
      int k = 0;
      for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) a[i][j] =
        Integer.parseInt(st[k++]);

      Solution ob = new Solution();
      ob.transpose(a, n);
      for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) System.out.print(
        a[i][j] + " "
      );

      System.out.println();
    }
  }
} // } Driver Code Ends

//User function Template for Java

class Solution {

  static void transpose(int matrix[][], int n) {
    // code here
    int temp;

    for (int i = 0; i < n; i++) for (int j = i + 1; j < n; j++) {
      temp = matrix[i][j];
      matrix[i][j] = matrix[j][i];
      matrix[j][i] = temp;
    }
  }
}
