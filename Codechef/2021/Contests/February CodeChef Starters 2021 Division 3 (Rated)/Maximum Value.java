/* package codechef; // don't place package name! */

import java.io.*;
import java.lang.*;
import java.util.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {

  public static long res(long a, long b) {
    return (a * b) + a - b;
  }

  public static long calculate(long nums[]) {
    Arrays.sort(nums);

    int n = nums.length;

    long res1, res2, res3;

    // both -ve
    res1 = res(nums[1], nums[0]);

    // both +ve
    res2 = res(nums[n - 1], nums[n - 2]);

    // if last = 0
    res3 = res(nums[n - 1], nums[0]);

    // (also runs without res3)
    return Math.max(Math.max(res1, res2), res3);
  }

  public static void main(String[] args) throws java.lang.Exception {
    // your code goes here

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine().trim());

    while (T-- > 0) {
      int n = Integer.parseInt(br.readLine().trim());

      String S[] = br.readLine().trim().split(" ");

      long nums[] = new long[S.length];

      for (int i = 0; i < nums.length; i++) {
        nums[i] = Long.parseLong(S[i]);
      }

      System.out.println(calculate(nums));
    }
  }
}
