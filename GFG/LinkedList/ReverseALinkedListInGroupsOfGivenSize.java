import java.lang.*;
import java.util.*;

class Node {

  int data;
  Node next;

  Node(int key) {
    data = key;
    next = null;
  }
}

class ReverseInSize {

  static Node head;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while (t-- > 0) {
      int n = sc.nextInt();
      int a1 = sc.nextInt();
      Node head = new Node(a1);
      Node tail = head;
      for (int i = 1; i < n; i++) {
        int a = sc.nextInt();
        // addToTheLast(new Node(a));
        tail.next = new Node(a);
        tail = tail.next;
      }

      int k = sc.nextInt();
      GfG gfg = new GfG();
      Node res = gfg.reverse(head, k);
      printList(res);
      System.out.println();
    }
  }

  public static void printList(Node node) {
    while (node != null) {
      System.out.print(node.data + " ");
      node = node.next;
    }
  }
}

// } Driver Code Ends

/*node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class GfG {

  public static Node reverse(Node node, int k) {
    //Your code here

    if (k == 1 || node == null || node.next == null) return node;

    int count = 1;

    Node part1 = node;

    Node prev = null;
    Node next = null;
    Node curr = node;

    while (count++ < k && curr.next != null) {
      next = curr.next;

      curr.next = prev;
      prev = curr;

      curr = next;
    }

    // important
    next = curr.next;

    curr.next = prev;

    Node head = curr;

    if (next == null) return head;

    while (true) {
      count = 1;

      Node part2 = next;

      prev = null;
      curr = next;
      next = null;

      while (count++ < k && curr.next != null) {
        next = curr.next;

        curr.next = prev;
        prev = curr;

        curr = next;
      }

      next = curr.next;

      part1.next = curr;

      curr.next = prev;

      if (next == null) return head;

      part1 = part2;
    }
  }
}
