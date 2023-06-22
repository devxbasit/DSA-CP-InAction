public class RepeatingAndMissingNumber {

  public static void method1(int arr[], int n) {
    int temp[] = new int[n];

    int repeating = -1;
    int missing = -1;

    for (int i = 0; i < n; i++) if (temp[arr[i] - 1] == 0) temp[arr[i] - 1] =
      1; else repeating = arr[i];

    for (int i = 0; i < n; i++) if (temp[i] != 1) {
      missing = i + 1;
      break;
    }

    System.out.printf("Repeating = %d, Missing = %d\n", repeating, missing);
  }

  public static void method2(int arr[], int n) {
    int missing = -1;
    int repeating = -1;

    for (int i = 0; i < n; i++) {
      if (arr[Math.abs(arr[i]) - 1] < 0) repeating = Math.abs(arr[i]);

      arr[Math.abs(arr[i]) - 1] *= -1;
    }

    for (int i = 0; i < n; i++) if (arr[i] > 0) missing = i + 1;

    System.out.printf("Repeating = %d, Missing = %d\n", repeating, missing);
  }

  public static void main(String[] args) {
    int arr[] = { 2, 3, 2, 5, 1 };
    method1(arr, arr.length); // T = O(n), S = O(n)
    method2(arr, arr.length); // T = O(n), S = O(1)
  }
}
