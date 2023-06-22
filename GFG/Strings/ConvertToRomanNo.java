import java.util.*;
import java.util.Scanner;

class ConvertToRomanNo {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t > 0) {
      int N = sc.nextInt();

      GfG g = new GfG();
      System.out.println(g.convertToRoman(N));
      t--;
    }
  }
} // } Driver Code Ends

/*you are required to complete this function*/
class GfG {

  String convertToRoman(int n) {
    // Your code here
    String units[] = {
      "",
      "I",
      "II",
      "III",
      "IV",
      "V",
      "VI",
      "VII",
      "VIII",
      "IX",
    };
    String tens[] = {
      "",
      "X",
      "XX",
      "XXX",
      "XL",
      "L",
      "LX",
      "LXX",
      "LXXX",
      "XC",
    };
    String hundreds[] = {
      "",
      "C",
      "CC",
      "CCC",
      "CD",
      "D",
      "DC",
      "DCC",
      "DCCC",
      "CM",
    };
    String thousands[] = { "", "M", "MM", "MMM" };

    return (
      thousands[n / 1000] +
      hundreds[(n % 1000) / 100] +
      tens[(n % 100) / 10] +
      units[n % 10]
    );
  }
}
