import java.io.*;
import java.lang.*;
import java.util.*;

class gfg {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while (t-- > 0) {
      int num = sc.nextInt();
      int k = sc.nextInt();

      int arr[] = new int[num];
      for (int i = 0; i < num; i++) arr[i] = sc.nextInt();

      ArrayList<Integer> res = new solve().nearlySorted(arr, num, k);
      for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
      System.out.println();
    }
  }
}

// } Driver Code Ends

class solve {

  ArrayList<Integer> nearlySorted(int arr[], int n, int k) {
    // your code here

    Queue<Integer> minHeap = new PriorityQueue<>();

    for (int i = 0; i < k; i++) minHeap.add(arr[i]);

    ArrayList<Integer> al = new ArrayList<>();

    for (int i = k; i < n; i++) {
      minHeap.add(arr[i]);

      al.add(minHeap.poll());
    }

    while (!minHeap.isEmpty()) {
      al.add(minHeap.poll());
    }

    return al;
  }
}
