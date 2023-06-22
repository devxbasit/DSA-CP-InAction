/* package codechef; // don't place package name! */

import java.io.*;
import java.lang.*;
import java.util.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {

  public static long calculate(String line[], int Q[], int x) {
    long episodes = Integer.parseInt(line[0]);

    if (episodes == 0) return 0;
    if (episodes == 1) return Integer.parseInt(line[1]);

    long sum = 0;
    for (int i = 1; i < line.length; i++) {
      sum += Integer.parseInt(line[i]);
    }

    return sum + Q[x] - (episodes * Q[x]);
  }

  public static void main(String[] args) throws java.lang.Exception {
    // your code goes here

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine().trim());

    while (T-- > 0) {
      int S = Integer.parseInt(br.readLine().trim());

      String line1[] = br.readLine().trim().split(" ");

      int Q[] = new int[line1.length];

      for (int i = 0; i < line1.length; i++) {
        Q[i] = Integer.parseInt(line1[i]);
      }

      long total = 0;

      for (int i = 0; i < S; i++) {
        line1 = br.readLine().trim().split(" ");

        total = total + calculate(line1, Q, i);
      }

      System.out.println(total);
    }
  }
}
