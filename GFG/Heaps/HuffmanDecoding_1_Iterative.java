// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;

class minHeapNode {

  char data;
  int freq;
  minHeapNode left, right;

  minHeapNode(char data, int freq) {
    left = right = null;
    this.data = data;
    this.freq = freq;
  }
}

class heapComparator implements Comparator<minHeapNode> {

  public int compare(minHeapNode h1, minHeapNode h2) {
    if (h1.freq < h2.freq) {
      return 1;
    } else if (h1.freq > h2.freq) {
      return -1;
    }
    return 0;
  }
}

class driverclass {

  static PriorityQueue<minHeapNode> heapq;
  static HashMap<Character, Integer> freqMap;
  static HashMap<Character, String> codes;

  static void storeCodes(minHeapNode root, String str) {
    if (root == null) return;
    if (root.data != '$') codes.put(root.data, str);
    storeCodes(root.left, str + "0");
    storeCodes(root.right, str + "1");
  }

  static void encodeString() {
    minHeapNode left, right, top;
    for (Map.Entry<Character, Integer> val : freqMap.entrySet()) {
      heapq.add(new minHeapNode(val.getKey(), val.getValue()));
    }
    while (heapq.size() != 1) {
      left = heapq.poll();
      right = heapq.poll();
      top = new minHeapNode('$', left.freq + right.freq);
      top.left = left;
      top.right = right;
      heapq.add(top);
    }
    storeCodes(heapq.peek(), "");
  }

  static void calcFreq(String str) {
    for (int i = 0; i < str.length(); i++) {
      Integer j = freqMap.get(str.charAt(i));
      freqMap.put(str.charAt(i), (j == null) ? 1 : j + 1);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().trim());
    while (t-- > 0) {
      String str = br.readLine().trim();
      heapq = new PriorityQueue<minHeapNode>(new heapComparator());
      codes = new HashMap<Character, String>();
      freqMap = new HashMap<Character, Integer>();
      String encodedString = "";
      calcFreq(str);
      encodeString();
      for (int i = 0; i < str.length(); i++) {
        encodedString += codes.get(str.charAt(i));
      }
      GfG g = new GfG();
      System.out.println(g.decodeString(heapq.peek(), encodedString));
    }
  }
}

// } Driver Code Ends

//User function Template for Java
class GfG {

  // your required to complete this function
  // this function should return the encoded string
  // see the main function for the minHeapNode reference
  String decodeString(minHeapNode root, String encodedStr) {
    // Code here

    // first we have to go left or right side then we have to check for
    // condition left && right == null or not

    minHeapNode node = root;

    int n = encodedStr.length();
    String res = "";

    for (int i = 0; i < n; i++) {
      node = encodedStr.charAt(i) == '0' ? node.left : node.right;

      if (node.left == null && node.right == null) {
        res += node.data;
        node = root;
      }
    }

    return res;
  }
}
