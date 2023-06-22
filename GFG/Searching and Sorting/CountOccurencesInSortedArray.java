import java.io.*;
import java.util.Arrays;

public class CountOccurencesInSortedArray {

  public static int findOccurences1(int arr[], int n, int x) {
    int index = Arrays.binarySearch(arr, x);

    int count = 1;

    for (int i = index - 1; i >= 0; i--) {
      if (arr[i] != x) break;

      count++;
    }

    for (int i = index + 1; i < n; i++) {
      if (arr[i] != x) break;

      count++;
    }

    return count;
  }

  public static int firstIndex(int arr[], int lb, int ub, int x) {
    if (lb <= ub) {
      int mid = (lb + ub) / 2;

      if (mid == 0 || arr[mid] == x && x > arr[mid - 1]) return mid;

      if (x > arr[mid]) return firstIndex(arr, mid + 1, ub, x);

      // ***
      // otherwise move towards left side
      return firstIndex(arr, lb, mid - 1, x);
    }

    return -1;
  }

  public static int lastIndex(int arr[], int lb, int ub, int x, int n) {
    if (lb <= ub) {
      int mid = (lb + ub) / 2;

      if (mid == n - 1 || arr[mid] == x && x < arr[mid + 1]) return mid;

      if (x < arr[mid]) return lastIndex(arr, lb, mid - 1, x, n);

      // ***
      // otherwise move towards right side
      return lastIndex(arr, mid + 1, ub, x, n);
    }

    return -1;
  }

  public static int findOccurences2(int arr[], int n, int x) {
    int i = firstIndex(arr, 0, n - 1, x);
    int j = lastIndex(arr, 0, n - 1, x, n);

    return (j - i) + 1;
  }

  public static void main(String[] args) throws IOException {
    int arr[] = { 1, 2, 2, 2, 2, 3, 3, 3, 6, 7, 7, 9, 9, 10, 10, 10 };

    for (int i : arr) System.out.printf("%d ", i);

    System.out.printf("\nFind the occurence of x :\t");

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int x = Integer.parseInt(br.readLine().trim());

    System.out.printf(
      "Occurences of %d = %d\n",
      x,
      findOccurences1(arr, arr.length, x)
    );

    // efficient one , find first & last index, return (last - first) + 1
    System.out.printf(
      "Occurences of %d = %d\n",
      x,
      findOccurences2(arr, arr.length, x)
    );
  }
}
