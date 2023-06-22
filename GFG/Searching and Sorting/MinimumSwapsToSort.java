// { Driver Code Starts
// Java program to find minimum number of swaps
// required to sort an array
import java.io.*;
import java.util.*;

// Driver class
class MinimumSwapsToSort {

  // Driver program to test the above function
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().trim());
    while (t-- > 0) {
      int n = Integer.parseInt(br.readLine().trim());
      String str[] = br.readLine().trim().split(" ");
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = Integer.parseInt(str[i]);
      }
      System.out.println(new GfG().minSwaps(a, n));
    }
  }
} // } Driver Code Ends

class GfG {

  class Pair implements Comparable<Pair> {

    int num;
    int index;

    Pair(int num, int index) {
      this.num = num;
      this.index = index;
    }

    public int compareTo(Pair other) {
      if (this.num > other.num) return 1;

      return -1;
    }
  }

  public static int find(int parent[], int x) {
    if (parent[x] == x) return x;

    return find(parent, parent[x]);
  }

  public static void union(int parent[], int size[], int x, int y) {
    int px = find(parent, x);
    int py = find(parent, y);

    if (px != py) {
      if (size[px] > size[py]) {
        parent[py] = px;
        size[px] += size[py];
        return;
      }

      parent[px] = py;
      size[py] += size[px];
    }
  }

  // return the minimum number of swaps required to sort the array
  public int minSwaps(int[] arr, int N) {
    ArrayList<Pair> al = new ArrayList<>();
    int parent[] = new int[N];
    int size[] = new int[N];

    for (int i = 0; i < N; i++) {
      parent[i] = i;
      size[i] = 1;
    }

    for (int i = 0; i < N; i++) al.add(new Pair(arr[i], i));

    Collections.sort(al);

    for (int i = 0; i < N; i++) union(parent, size, i, al.get(i).index);

    int minSwaps = 0;
    for (int i = 0; i < N; i++) if (parent[i] == i) minSwaps += size[i] - 1;

    return minSwaps;
  }
}
