/* package codechef; // don't place package name! */

import java.io.*;
import java.lang.*;
import java.util.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {

  public static int countGroups(String S) {
    int groups = 0;

    boolean friends = false;

    for (int i = 0; i < S.length(); i++) {
      if (S.charAt(i) == '0') {
        friends = false;
        continue;
      }

      if (friends) {
        continue;
      }

      friends = true;
      groups++;
    }

    return groups;
  }

  public static void main(String[] args) throws java.lang.Exception {
    // your code goes here

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine().trim());

    while (T-- > 0) {
      String S = br.readLine().trim();

      System.out.println(countGroups(S));
    }
  }
}
