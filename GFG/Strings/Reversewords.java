import java.io.*;
import java.lang.*;
import java.util.*;

class Reversewords {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t > 0) {
      String s = sc.next();
      Solution obj = new Solution();
      System.out.println(obj.reverseWords(s));
      t--;
    }
  }
}

// } Driver Code Ends

class Solution {

  String reverseWords(String S) {
    // code here
    String rev = "";
    String str[] = S.split("\\.");
    int n = str.length - 1;

    for (int i = n; i >= 0; i--) {
      rev += str[i];
      if (i != 0) rev += ".";
    }

    return rev;
  }
}
