// https://leetcode.com/problems/copy-list-with-random-pointer/
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

  public Node copyRandomList(Node head) {
    if (head == null) return null;

    Node node = head;

    while (node != null) {
      Node newNode = new Node(node.val);

      newNode.next = node.next;

      node.next = newNode;

      node = node.next.next;
    }

    Node head2 = head.next;

    node = head;

    while (node != null) {
      if (node.random == null) {
        node = node.next.next;
        continue;
      }

      node.next.random = node.random.next;

      node = node.next.next;
    }

    node = head;

    while (node != null) {
      System.out.println(" " + node.val);
      System.out.println(" " + node.next.val);

      // if last node
      if (node.next.next == null) {
        node.next = null;
        node = null;
        continue;
      }

      // else fix both node's next links

      Node next = node.next.next;

      node.next.next = next.next;

      node.next = next;

      node = next;
    }

    return head2;
  }
}
