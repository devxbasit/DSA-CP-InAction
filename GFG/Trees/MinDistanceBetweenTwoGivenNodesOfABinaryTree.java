// { Driver Code Starts
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

class Main {

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

    int t = Integer.parseInt(br.readLine().trim());

    while (t-- > 0) {
      String s = br.readLine().trim();
      Node root = buildTree(s);
      String[] ab = br.readLine().trim().split(" ");
      int a = Integer.parseInt(ab[0]);
      int b = Integer.parseInt(ab[1]);

      GfG g = new GfG();
      System.out.println(g.findDist(root, a, b));
    }
  }
}

// } Driver Code Ends

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

/* Should return minimum distance between a and b
   in a tree with given root*/
class GfG {

  Node lca(Node node, int a, int b) {
    if (node == null) return null;

    if (node.data == a || node.data == b) return node;

    Node left = lca(node.left, a, b);
    Node right = lca(node.right, a, b);

    if (left == null) return right;

    if (right == null) return left;

    return node;
  }

  int findLevel(Node node, int key, int currLevel) {
    if (node == null) return -1;

    if (node.data == key) return currLevel;

    int left = findLevel(node.left, key, currLevel + 1);

    if (left == -1) return findLevel(node.right, key, currLevel + 1);

    return left;
  }

  int findDist(Node root, int a, int b) {
    // Your code here
    Node ancestor = lca(root, a, b);

    // another method to find distance
    // Dist(n1, n2) = Dist(root, n1) + Dist(root, n2) - 2*Dist(root, lca)

    int d1 = findLevel(ancestor, a, 0);
    int d2 = findLevel(ancestor, b, 0);

    if (d1 == -1 || d2 == -1) return -1;

    return d1 + d2;
  }
}
