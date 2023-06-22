import java.util.*;

class StackUsingQueues {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t > 0) {
      Queues g = new Queues();

      int q = sc.nextInt();
      while (q > 0) {
        int QueryType = sc.nextInt();
        if (QueryType == 1) {
          int a = sc.nextInt();
          g.push(a);
        } else if (QueryType == 2) System.out.print(g.pop() + " ");
        q--;
      }
      System.out.println();

      t--;
    }
  }
}

// } Driver Code Ends

class Queues {

  Queue<Integer> q1 = new LinkedList<Integer>();

  /*The method pop which return the element poped out of the stack*/
  int pop() {
    // Your code here

    if (q1.isEmpty()) return -1;

    int s = q1.size() - 1;

    while (s-- > 0) q1.add(q1.remove());

    return q1.remove();
  }

  /* The method push to push element into the stack */
  void push(int a) {
    // Your code here

    q1.add(a);
  }
}
