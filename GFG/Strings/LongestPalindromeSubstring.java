// Initial Template for Java

import java.io.*;
import java.util.*;

class LongestPalindromeSubstring {

  // Driver program to test above function
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine().trim());
    while (tc-- > 0) {
      String str = br.readLine().trim();
      Solution sln = new Solution();
      System.out.println(sln.longestPalindrome(str));
    }
  }
} // } Driver Code Ends

// User function Template for Java

class Solution {

  // complete this function
  int maxLen = 0;
  int beginIndex;

  public void expandRange(String s, int begin, int end) {
    while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
      begin--;
      end++;
    }

    if (maxLen < end - begin - 1) {
      maxLen = end - begin - 1;
      beginIndex = begin + 1;
    }
  }

  public String longestPalindrome(String S) {
    // code here
    if (S.length() < 2) return S;

    for (int start = 0; start < S.length() - 1; start++) {
      expandRange(S, start, start);
      expandRange(S, start, start + 1);
    }

    return S.substring(beginIndex, beginIndex + maxLen);
  }
}
