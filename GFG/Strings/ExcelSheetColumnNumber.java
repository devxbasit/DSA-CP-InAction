// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class ExcelSheetColumnNumber {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    while (t > 0) {
      String s = br.readLine();
      Solution T = new Solution();

      System.out.println(T.excelColumnNumber(s));

      t--;
    }
  }
} // } Driver Code Ends

//User function Template for Java

class Solution {

  public int excelColumnNumber(String s) {
    // Code here

    int b = 26;
    int p = 0;
    int sum = 0;

    for (int i = s.length() - 1; i >= 0; i--) sum +=
      (s.charAt(i) - 64) * Math.pow(b, p++);

    return sum;
  }
}
