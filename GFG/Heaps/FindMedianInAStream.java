import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    int n;
    while (t-- > 0) {
      n = sc.nextInt();

      FindMedian Ans = new FindMedian();
      for (int i = 1; i <= n; i++) {
        int x = sc.nextInt();
        Ans.insertHeap(x);
        System.out.println((int) Math.floor(Ans.getMedian()));
      }
    }
  }
}

// } Driver Code Ends

class FindMedian {

  static PriorityQueue<Integer> max = new PriorityQueue<>(
    Collections.reverseOrder()
  );
  static PriorityQueue<Integer> min = new PriorityQueue<>();

  // Function to insert heap

  public static void insertHeap(int x) {
    // add your code here

    if (max.isEmpty() || x < max.peek()) {
      max.add(x);
    } else {
      min.add(x);
    }

    balanceHeaps();
  }

  // Function to balance Heaps
  public static void balanceHeaps() {
    // add your code here

    if (max.size() > min.size() + 1) {
      min.add(max.poll());
    } else if (min.size() > max.size() + 1) {
      max.add(min.poll());
    }
  }

  // function to getMedian
  public static double getMedian() {
    // add your code here

    if (min.isEmpty() && max.isEmpty()) return -1.0;

    if (max.size() > min.size()) {
      return (double) max.peek();
    } else if (min.size() > max.size()) {
      return (double) min.peek();
    }

    return (max.peek() + min.peek()) / 2.0;
  }
}
