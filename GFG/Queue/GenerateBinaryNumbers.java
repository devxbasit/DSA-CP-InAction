import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

  public static void main(String args[]) {
    //Taking input using class Scanner
    Scanner sc = new Scanner(System.in);

    //Taking the number of testcases
    int t = sc.nextInt();

    while (t-- > 0) {
      //taking the range
      int n = sc.nextInt();

      //creating an ArrayList
      ArrayList<String> res = new ArrayList<String>();

      //calling the generate method of class solve
      //and storing the result in an ArrayList
      res = new solve().generate(n);

      //printing all the elements of the ArrayList
      for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
      System.out.println();
    }
  }
} // } Driver Code Ends

class solve {

  static ArrayList<String> generate(int N) {
    // Your code here
    ArrayList<String> al = new ArrayList<>();

    Queue<String> queue = new LinkedList<>();

    queue.add("1");

    while (N-- > 0) {
      al.add(queue.peek());

      queue.add(queue.peek() + "0");
      queue.add(queue.remove() + "1");
    }

    return al;
  }
}
