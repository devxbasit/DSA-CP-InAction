// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class LongestSubstringWithoutRepeatingCharacters {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    while (t > 0) {
      String s = br.readLine();
      Solution T = new Solution();

      System.out.println(T.SubsequenceLength(s));

      t--;
    }
  }
}

// } Driver Code Ends

//User function Template for Java

class Solution {

  int SubsequenceLength(String s) {
    // Code here
    int maxSoFar = 0;
    int n = s.length();

    int lastSeen[] = new int[256];
    Arrays.fill(lastSeen, -1);

    int ch;

    for (int l = 0, r = 0; r < n; r++) {
      ch = s.charAt(r);

      if (lastSeen[ch] == -1 || lastSeen[ch] < l) {
        if (r - l + 1 > maxSoFar) maxSoFar = r - l + 1;
      } else {
        // that means lastSeen[ch] is within the range l --- r
        l = lastSeen[ch] + 1;
      }

      lastSeen[ch] = r;
    }

    return maxSoFar;
  }
}
