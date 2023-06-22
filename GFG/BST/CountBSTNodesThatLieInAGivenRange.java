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
      String[] ab = br.readLine().trim().split(" ");
      int a = Integer.parseInt(ab[0]);
      int b = Integer.parseInt(ab[1]);
      Node root = buildTree(s);
      Tree g = new Tree();
      System.out.println(g.getCount(root, a, b));
      t--;
    }
  }
}

// } Driver Code Ends

// A Binary Search Tree node
/*

class Node
{
    int data;
    Node left;
    Node right;
    
    Node(int data){
        this.data = data;
        this.left = this.right = null;
    }
}

*/
//Complete this function
class Tree {

  class Count {

    int n;
  }

  void getCountRecur(Node node, int low, int high, Count count) {
    if (node != null) {
      if (node.data >= low && node.data <= high) {
        count.n += 1;

        getCountRecur(node.left, low, high, count);
        getCountRecur(node.right, low, high, count);
      } else if (node.data > high) getCountRecur(
        node.left,
        low,
        high,
        count
      ); else getCountRecur(node.right, low, high, count);
    }
  }

  int getCount(Node root, int l, int h) {
    //Your code here

    Count count = new Count();

    getCountRecur(root, l, h, count);

    return count.n;
  }
}
