// { Driver Code Starts
// INITIAL CODE

// Contributed by Sudarshan Sharma
import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {

  int data;
  Node left;
  Node right;

  Node(int data) {
    this.data = data;
    left = null;
    right = null;
  }
}

class GfG {

  static Node buildTree(String str) {
    if (str.length() == 0 || str.charAt(0) == 'N') {
      return null;
    }

    String ip[] = str.split(" ");
    // Create the root of the tree
    Node root = new Node(Integer.parseInt(ip[0]));
    // Push the root to the queue

    Queue<Node> queue = new LinkedList<>();

    queue.add(root);
    // Starting from the second element

    int i = 1;
    while (queue.size() > 0 && i < ip.length) {
      // Get and remove the front of the queue
      Node currNode = queue.peek();
      queue.remove();

      // Get the current node's value from the string
      String currVal = ip[i];

      // If the left child is not null
      if (!currVal.equals("N")) {
        // Create the left child for the current node
        currNode.left = new Node(Integer.parseInt(currVal));
        // Push it to the queue
        queue.add(currNode.left);
      }

      // For the right child
      i++;
      if (i >= ip.length) break;

      currVal = ip[i];

      // If the right child is not null
      if (!currVal.equals("N")) {
        // Create the right child for the current node
        currNode.right = new Node(Integer.parseInt(currVal));

        // Push it to the queue
        queue.add(currNode.right);
      }
      i++;
    }

    return root;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    while (t-- > 0) {
      String s = br.readLine();
      String s1 = br.readLine();
      Node root = buildTree(s);
      Node root1 = buildTree(s1);
      Tree g = new Tree();
      if (g.areMirror(root, root1)) {
        System.out.println(1);
      } else {
        System.out.println(0);
      }
    }
  }
} // } Driver Code Ends

// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

class Tree {

  boolean areMirror(Node a, Node b) {
    // Your code here

    // using level order traversal
    if (a == null || b == null) return false;

    Queue<Node> que1 = new LinkedList<>();
    Queue<Node> que2 = new LinkedList<>();

    que1.add(a);
    que2.add(b);

    while (!que1.isEmpty() && !que2.isEmpty()) {
      Node n1 = que1.remove();
      Node n2 = que2.remove();

      if (n1.data != n2.data) return false;

      if (n1.left != null) que1.add(n1.left);

      if (n1.right != null) que1.add(n1.right);

      if (n2.right != null) que2.add(n2.right);

      if (n2.left != null) que2.add(n2.left);
    }

    if (que1.isEmpty() && que2.isEmpty()) return true; else return false;
  }
}
