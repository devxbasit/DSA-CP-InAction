// { Driver Code Starts
//Initial Template for Java
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

class GFG {

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

  static void printInorder(Node root) {
    if (root == null) return;

    printInorder(root.left);
    System.out.print(root.data + " ");

    printInorder(root.right);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    while (t > 0) {
      String s = br.readLine();
      Node root = buildTree(s);

      Solution ob = new Solution();
      System.out.println(ob.dupSub(root));
      t--;
    }
  }
}

// } Driver Code Ends

//User function Template for Java
/* A Binary Tree node

class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
 */

class Solution {

  boolean found = false;

  String dupRecur(Node node, HashSet<String> hs) {
    if (node == null) return "$";

    if (node.left == null && node.right == null) return (
      String.valueOf(node.data) + "$$"
    );

    String S = String.valueOf(node.data);

    String left = dupRecur(node.left, hs);

    if (found == true) return left;

    String right = dupRecur(node.right, hs);

    if (found == true) return right;

    S = S + left + right;

    if (hs.contains(S)) {
      found = true;
      return S;
    }

    hs.add(S);
    return S;
  }

  int dupSub(Node root) {
    // code here

    HashSet<String> hs = new HashSet<>();

    dupRecur(root, hs);

    return found == true ? 1 : 0;
  }
}
