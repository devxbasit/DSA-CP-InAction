//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class GFG {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();

    while (t-- > 0) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int a1[] = new int[n];
      int a2[] = new int[m];

      for (int i = 0; i < n; i++) a1[i] = sc.nextInt();

      for (int i = 0; i < m; i++) a2[i] = sc.nextInt();
      sortA1ByA2(a1, n, a2, m);
      for (int x : a1) System.out.print(x + " ");

      System.out.println();
    }
  }

  // } Driver Code Ends

  //User function Template for Java

  // A1[] : the input array-1
  // N : size of the array A1[]
  // A2[] : the input array-2
  // M : size of the array A2[]

  public static void sortA1ByA2(int A1[], int N, int A2[], int M) {
    //Your code here

    HashMap<Integer, Integer> hm = new HashMap<>();

    for (int i = 0; i < N; i++) hm.put(A1[i], hm.getOrDefault(A1[i], 0) + 1);

    PriorityQueue<Map.Entry<Integer, Integer>> pque = new PriorityQueue<>(
      new Comparator<Map.Entry<Integer, Integer>>() {
        public int compare(
          Map.Entry<Integer, Integer> e1,
          Map.Entry<Integer, Integer> e2
        ) {
          return e1.getKey() - e2.getKey();
        }
      }
    );

    for (Map.Entry<Integer, Integer> entry : hm.entrySet()) pque.add(entry);

    int i = 0;
    int freq;

    for (int j = 0; j < M; j++) if (hm.containsKey(A2[j])) {
      freq = hm.get(A2[j]);

      while (freq-- > 0) A1[i++] = A2[j];

      hm.remove(A2[j]);
    }

    // System.out.println(pque.peek());

    // System.out.println("size " + hm.size());

    int item;
    while (hm.size() > 0) {
      // System.out.println("slakjfdlj aldsfjk lajf");

      while (!hm.containsKey(pque.peek().getKey())) pque.remove();

      Map.Entry<Integer, Integer> entry = pque.peek();

      item = entry.getKey();
      freq = entry.getValue();

      while (freq-- > 0) A1[i++] = item;

      hm.remove(item);
      pque.remove();
    }
  }
  // { Driver Code Starts.

}
// } Driver Code Ends
