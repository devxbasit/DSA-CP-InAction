import java.util.*;

class RemainderWith7 {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    sc.nextLine();
    while (t > 0) {
      String str = sc.nextLine();
      GfG g = new GfG();
      System.out.println(g.remainderWith7(str));
      t--;
    }
  }
} // } Driver Code Ends

class GfG {

  // Complete the function
  int remainderWith7(String str) {
    // Your code here
    int n = str.length();
    int num, rem = 0;

    for (int i = 0; i < n; i++) {
      num = rem * 10 + (str.charAt(i) - '0');
      rem = num % 7;
    }

    return rem;
  }
}
