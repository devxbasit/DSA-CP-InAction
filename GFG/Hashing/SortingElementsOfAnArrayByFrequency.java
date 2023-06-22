//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Map.Entry;

class Driverclass {

  public static void main(String[] args)
    throws NumberFormatException, IOException {
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(sc.readLine());
    while (n != 0) {
      int size = Integer.parseInt(sc.readLine());
      int arr[] = new int[size];
      String[] temp = sc.readLine().trim().split("\\s+");

      for (int i = 0; i < size; i++) arr[i] = Integer.parseInt(temp[i]);

      ArrayList<Integer> ans = new ArrayList<Integer>();
      ans = new Sorting().sortByFreq(arr, size);
      for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
      System.out.println();
      n--;
    }
  }
}

// } Driver Code Ends

//User function Template for Java

class Sorting {

  static class Pair implements Comparable<Pair> {

    int item;
    int freq;

    Pair(int item, int freq) {
      this.item = item;
      this.freq = freq;
    }

    public int compareTo(Pair p) {
      if (this.freq == p.freq) return this.item - p.item;

      return p.freq - this.freq;
    }
  }

  static ArrayList<Integer> sortByFreq(int arr[], int n) {
    // add your code here

    Map<Integer, Integer> hm = new HashMap<>();

    for (int i = 0; i < n; i++) hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);

    ArrayList<Pair> al = new ArrayList<>();

    int key;
    int freq;

    for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
      key = (int) entry.getKey();
      freq = (int) entry.getValue();

      al.add(new Pair(key, freq));
    }

    Collections.sort(al);
    ArrayList<Integer> res = new ArrayList<>();

    for (Pair pair : al) res.addAll(Collections.nCopies(pair.freq, pair.item));

    return res;
  }
}
