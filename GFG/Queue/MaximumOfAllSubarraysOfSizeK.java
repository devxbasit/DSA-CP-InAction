// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class gfg {

  public static void main(String args[]) {
    //taking input using class Scanner
    Scanner sc = new Scanner(System.in);

    //taking total count of testcases
    int t = sc.nextInt();

    while (t-- > 0) {
      //taking total number of elements
      int n = sc.nextInt();

      //taking size of subArrays
      int k = sc.nextInt();

      //Declaring and Intializing an array of size n
      int arr[] = new int[n];

      //adding all the elements to the array
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }

      //Calling the method max_of_subarrays of class solve
      //and storing the result in an ArrayList
      ArrayList<Integer> res = new solve().max_of_subarrays(arr, n, k);

      //printing the elements of the ArrayList
      for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
      System.out.println();
    }
  }
} // } Driver Code Ends

class solve {

  static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
    // Your code here

    ArrayList<Integer> al = new ArrayList<>();
    Deque<Integer> deque = new LinkedList<>();

    int i;

    for (i = 0; i < k; i++) {
      while (
        !deque.isEmpty() && arr[i] >= arr[deque.peekLast()]
      ) deque.removeLast();

      deque.addLast(i);
    }

    for (; i < n; i++) {
      al.add(arr[deque.peekFirst()]);

      // we can replace below "while (condition) with if(condition), while just make it more generic

      // if (deque.peekFirst() == i - k)
      while (
        !deque.isEmpty() && deque.peekFirst() <= i - k
      ) deque.removeFirst();

      while (
        !deque.isEmpty() && arr[i] >= arr[deque.peekLast()]
      ) deque.removeLast();

      deque.addLast(i);
    }

    al.add(arr[deque.peekFirst()]);

    return al;
  }
}
