//Initial Template for Java

import java.math.*;
import java.util.*;

class Multiply {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      String a = sc.next();
      String b = sc.next();
      Sol g = new Sol();
      System.out.println(g.multiplyStrings(a, b));
    }
  }
} // } Driver Code Ends

//User function Template for Java

class MultiplyTwoStrings {

  public String multiplyStrings(String s1, String s2) {
    //code here.
    if (s1 == "0" || s2 == "0") return "0";

    if (s1 == "1") return s2;

    if (s2 == "1") return s1;

    int sign = 1;

    if (s1.charAt(0) == '-') {
      sign *= -1;
      s1 = s1.substring(1);
    }

    if (s2.charAt(0) == '-') {
      sign *= -1;
      s2 = s2.substring(1);
    }

    int vals[] = new int[s1.length() + s2.length()];

    int sum, mul;

    for (int j = s2.length() - 1; j >= 0; j--) {
      for (int i = s1.length() - 1; i >= 0; i--) {
        mul = (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
        sum = vals[i + j + 1] + mul;

        vals[i + j + 1] = sum % 10;

        vals[i + j] += sum / 10;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int val : vals) {
      if (sb.length() != 0 || val != 0) sb.append(val);
    }

    if (sb.length() == 0) return "0";

    if (sign == -1) sb.insert(0, "-");

    return sb.toString();
  }
}
