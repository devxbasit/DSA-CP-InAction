class IndexOfFirst1 {

  public static int firstIndex(int arr[], int lb, int ub, int n) {
    if (lb <= ub) {
      int mid = lb + (ub - lb) / 2;

      if (
        mid == 0 || mid == n - 1 || arr[mid] == 1 && arr[mid - 1] == 0
      ) return mid;

      if (arr[mid] == 0) return firstIndex(arr, mid + 1, ub, n);

      return firstIndex(arr, lb, mid - 1, n);
    }
    return -1;
  }

  public static void main(String[] args) {
    int arr[] = { 0, 0, 0, 0, 0, 0, 1, 1, 1, 1 };
    System.out.printf(
      "Index of first 1 =  %d\n",
      firstIndex(arr, 0, arr.length - 1, arr.length)
    );
  }
}
