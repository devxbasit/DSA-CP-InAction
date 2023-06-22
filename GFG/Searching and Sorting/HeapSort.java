public class HeapSort {

  public void swap(int x, int y) {}

  public static void heapify(int arr[], int n, int i) {
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;

    if (l < n && arr[l] > arr[largest]) largest = l;

    if (r < n && arr[r] > arr[largest]) largest = r;

    if (largest != i) {
      int temp = arr[i];
      arr[i] = arr[largest];
      arr[largest] = temp;

      heapify(arr, n, largest);
    }
  }

  public static void HSort(int arr[], int n) {
    int nonLeaf = n / 2 - 1;

    for (int i = nonLeaf; i >= 0; i--) heapify(arr, n, i);

    for (int i = n - 1; i >= 0; i--) {
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;

      // *** call max heapify on the reduced heap
      heapify(arr, i, 0);
    }
  }

  public static void main(String[] args) {
    int arr[] = { 4, 3, 2, -10, 12, 1, 1, 5, 6 };

    for (int i : arr) System.out.printf("%d\t", i);

    System.out.printf("\nAfter Heap sort\n");

    HSort(arr, arr.length);

    for (int i : arr) System.out.printf("%d\t", i);

    System.out.println();
  }
}
