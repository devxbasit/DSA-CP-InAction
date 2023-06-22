import java.util.*;
import java.util.Scanner;

class Max_Dis_Between_Same_Element {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t > 0) {
      int n = sc.nextInt();
      int arr[] = new int[n];
      for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
      GfG g = new GfG();
      System.out.println(g.maxDistance(arr, n));

      t--;
    }
  }
} // } Driver Code Ends

// your task is to complete this function
class GfG {

  int maxDistance(int arr[], int n) {
    // Your code here

    Map<Integer, Integer> hm = new HashMap<>();

    int max = 0;
    int d;

    for (int i = 0; i < n; i++) {
      if (hm.containsKey(arr[i])) max =
        Math.max(max, i - hm.get(arr[i])); else hm.put(arr[i], i);
    }

    return max;
  }
}
