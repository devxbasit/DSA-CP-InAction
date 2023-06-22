// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GfG {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().trim());
    while (t-- > 0) {
      String inputLine[] = br.readLine().trim().split(" ");
      int n = Integer.parseInt(inputLine[0]);
      inputLine = br.readLine().trim().split(" ");
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(inputLine[i]);
      }
      int k = Integer.parseInt(br.readLine().trim());
      new solve().kMostFrequent(arr, n, k);
    }
  }
} // } Driver Code Ends

class solve {

  class Pair implements Comparable<Pair> {

    int element;
    int freq;

    Pair(int element, int freq) {
      this.element = element;
      this.freq = freq;
    }

    public int compareTo(Pair p) {
      return this.freq - p.freq;
    }
  }

  void kMostFrequent(int arr[], int n, int k) {
    // your code here

    Map<Integer, Integer> hm = new HashMap<>();

    for (int ele : arr) {
      hm.put(ele, hm.getOrDefault(ele, 0) + 1);
    }

    // we can also do it using max heap, but time complexity will be little more
    Queue<Pair> minHeap = new PriorityQueue<>();

    int key, val, index = 0;

    for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
      key = entry.getKey();
      val = entry.getValue();

      if (index < k + 1) {
        minHeap.add(new Pair(key, val));
        index++;
      } else {
        minHeap.poll();
        minHeap.add(new Pair(key, val));
      }
    }

    minHeap.poll();

    int freqSum = 0;
    while (!minHeap.isEmpty()) {
      freqSum += minHeap.poll().freq;
    }

    System.out.println(freqSum);
  }
}
