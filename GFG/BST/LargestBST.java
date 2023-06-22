/*package whatever //do not write package name here */

import java.io.*;
import java.math.*;
import java.util.*;

class Node {

  int data;
  Node left, right;

  public Node(int d) {
    data = d;
    left = right = null;
  }
}

class GFG {

  static Node buildTree(String str) {
    // Corner Case
    if (str.length() == 0 || str.equals('N')) return null;
    String[] s = str.split(" ");

    Node root = new Node(Integer.parseInt(s[0]));
    Queue<Node> q = new LinkedList<Node>();
    q.add(root);

    // Starting from the second element
    int i = 1;
    while (!q.isEmpty() && i < s.length) {
      // Get and remove the front of the queue
      Node currNode = q.remove();

      // Get the curr node's value from the string
      String currVal = s[i];

      // If the left child is not null
      if (!currVal.equals("N")) {
        // Create the left child for the curr node
        currNode.left = new Node(Integer.parseInt(currVal));

        // Push it to the queue
        q.add(currNode.left);
      }

      // For the right child
      i++;
      if (i >= s.length) break;
      currVal = s[i];

      // If the right child is not null
      if (!currVal.equals("N")) {
        // Create the right child for the curr node
        currNode.right = new Node(Integer.parseInt(currVal));

        // Push it to the queue
        q.add(currNode.right);
      }

      i++;
    }

    return root;
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().trim());
    while (t > 0) {
      String s = br.readLine();
      Node root = buildTree(s);

      Solution T = new Solution();
      System.out.println(T.largestBst(root));

      t--;
    }
  }
}

// } Driver Code Ends

//User function Template for Java

// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {

  // Return the size of the largest sub-tree which is also a BST

  static class Info {

    boolean isBST;
    int count;
    int min;
    int max;

    Info(boolean isBST, int count, int min, int max) {
      this.isBST = isBST;
      this.count = count;
      this.min = min;
      this.max = max;
    }
  }

  static Info largestBSTRecur(Node node) {
    if (node.left == null && node.right == null) return new Info(
      true,
      1,
      node.data,
      node.data
    );

    Info left = (node.left != null)
      ? largestBSTRecur(node.left)
      : new Info(true, 0, node.data, node.data - 1);

    Info right = (node.right != null)
      ? largestBSTRecur(node.right)
      : new Info(true, 0, node.data + 1, node.data);

    if (left.isBST == false || right.isBST == false) return new Info(
      false,
      Math.max(left.count, right.count),
      0,
      0
    );

    // both childs are BST
    // check for root

    if (left.max < node.data && right.min > node.data) return new Info(
      true,
      left.count + right.count + 1,
      left.min,
      right.max
    ); else return new Info(false, Math.max(left.count, right.count), 0, 0);
  }

  static int largestBst(Node root) {
    // Write your code here

    return largestBSTRecur(root).count;
  }
}
