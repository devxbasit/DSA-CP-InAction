/* package codechef; // don't place package name! */

import java.io.*;
import java.lang.*;
import java.util.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {

  public static void main(String[] args) throws java.lang.Exception {
    // your code goes here

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String line[] = br.readLine().trim().split(" ");

    int n = Integer.parseInt(line[0]);

    String diff = String.valueOf(
      Integer.parseInt(line[1]) - Integer.parseInt(line[2])
    );

    line = br.readLine().trim().split(" ");

    boolean flag = false;

    for (int i = 0; i < line.length; i++) {
      if (line[i].equals(diff)) {
        flag = true;
        break;
      }
    }

    if (flag) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }
}
