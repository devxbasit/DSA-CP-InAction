import java.util.*;

class PeakElement {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) a[i] = sc.nextInt();

      int A = new Peak().peakElement(a, n);
      int f = 0;
      if (n == 1) f = 1; else if (A == 0 && a[0] >= a[1]) f = 1; else if (
        A == n - 1 && a[n - 1] >= a[n - 2]
      ) f = 1; else if (a[A] >= a[A + 1] && a[A] >= a[A - 1]) f = 1; else f = 0;
      System.out.println(f);
    }
  }
} // } Driver Code Ends

/*Complete the function below*/

class Peak {

  public int findPeak(int arr[], int low, int high, int n) {
    if (low < high) {
      int mid = low + (high - low) / 2;

      if (
        (mid == 0 || arr[mid] >= arr[mid - 1]) &&
        (mid == n - 1 || arr[mid] >= arr[mid + 1])
      ) return mid;

      if (mid > 0 && arr[mid - 1] >= arr[mid]) return findPeak(
        arr,
        low,
        mid - 1,
        n
      ); else return findPeak(arr, mid + 1, high, n);
    }

    return low;
  }

  // Function to find the peak element
  // a[]: input array
  // n: size of array a[]
  public int peakElement(int[] a, int n) {
    //add code here.
    return findPeak(a, 0, n - 1, n);
  }
}
