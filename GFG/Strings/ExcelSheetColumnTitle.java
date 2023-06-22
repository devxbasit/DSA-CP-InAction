// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class ExcelSheetColumnTitle {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    while (t > 0) {
      int n = Integer.parseInt(br.readLine());
      Solution T = new Solution();

      System.out.println(T.excelColumn(n));

      t--;
    }
  }
} // } Driver Code Ends

//User function Template for Java

class Solution {

  public String excelColumn(int N) {
    //  Your code here
    StringBuilder sb = new StringBuilder();
    int r;

    while (N > 0) {
      r = N % 26;

      if (r == 0) {
        sb.insert(0, 'Z');
        N = N / 26 - 1;
      } else {
        sb.insert(0, (char) ((r - 1) + 'A'));
        N /= 26;
      }
    }

    return sb.toString();
  }
}
