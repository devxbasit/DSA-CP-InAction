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

class Occurrence {

  static Node head;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while (t-- > 0) {
      int n = sc.nextInt();
      int a1 = sc.nextInt();
      Node head = new Node(a1);
      addToTheLast(head);
      for (int i = 1; i < n; i++) {
        int a = sc.nextInt();
        addToTheLast(new Node(a));
      }

      int k = sc.nextInt();
      GfG gfg = new GfG();
      System.out.println(gfg.count(head, k));
    }
  }

  public static void addToTheLast(Node node) {
    if (head == null) {
      head = node;
    } else {
      Node temp = head;
      while (temp.next != null) temp = temp.next;
      temp.next = node;
    }
  }
} // } Driver Code Ends

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
}*/
// complete the below function
class GfG {

  public static int count(Node head, int searchFor) {
    //code here

    if (head == null) return -1;

    int count = 0;

    Node temp = head;

    while (temp != null) {
      if (temp.data == searchFor) count++;

      temp = temp.next;
    }

    return count;
  }
}
