// { Driver Code Starts
import java.util.Scanner;

class FindTheSQRT {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t > 0) {
      long a = sc.nextInt();
      SquareRoot obj = new SquareRoot();
      System.out.println(obj.floorSqrt(a));
      t--;
    }
  }
} // } Driver Code Ends

/*You are required to complete
    this function*/

// Function to find square root
// x: element to find square root
class SquareRoot {

  public static long binarySearch(long low, long high, long x) {
    if (x == 0 || x == 1) return x;

    if (low <= high) {
      long mid = low + (high - low) / 2;

      if (mid == x / mid) return mid;

      if (mid < x / mid) return binarySearch(
        mid + 1,
        high,
        x
      ); else return binarySearch(low, mid - 1, x);
    }

    return high;
  }

  long floorSqrt(long x) {
    // Your code here
    return binarySearch(1, x / 2, x);
  }
}
