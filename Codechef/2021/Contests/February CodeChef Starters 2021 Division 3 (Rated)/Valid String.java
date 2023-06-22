/* package codechef; // don't place package name! */

import java.io.*;
import java.lang.*;
import java.util.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {

  public static boolean possible(String S, int C) {
    if (S.length() <= 2) return true;

    int i = 0;
    int j = S.length() - 1;

    int count = 0;
    int len = 0;

    while (i < S.length() && S.charAt(i) == '0') i++;
    while (j >= 0 && S.charAt(j) == '0') j--;

    int cyclicZeros = 0;

    //S = 000000 or 00000100000
    if (i >= j) return true;

    cyclicZeros = i + ((S.length() - 1) - j);

    if (cyclicZeros > C) count++;

    while (i <= j) {
      len = 0;
      i++;

      while (i <= j && S.charAt(i) == '0') {
        len++;
        i++;
      }

      if (len > C) count++;
      if (count >= 2) return false;
    }

    return true;
  }

  public static void main(String[] args) throws java.lang.Exception {
    // your code goes here

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine().trim());

    while (T-- > 0) {
      String line1[] = br.readLine().trim().split(" ");

      int N = Integer.parseInt(line1[0]);
      int C = Integer.parseInt(line1[1]);

      String S = br.readLine().trim();

      if (possible(S, C)) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }
}
