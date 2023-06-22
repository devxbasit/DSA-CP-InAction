//Initial Template for Java

import java.io.*;
import java.lang.Math;
import java.util.Scanner;

class Node {

  int data;
  Node left, right;

  Node(int d) {
    data = d;
    left = right = null;
  }
}

class GFG2 {

  public static void inorder(Node root) {
    if (root == null) return;
    inorder(root.left);
    System.out.print(root.data + " ");
    inorder(root.right);
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int[] post = new int[n];
      for (int i = 0; i < n; i++) {
        int b = sc.nextInt();
        post[i] = b;
      }
      GFG obj = new GFG(n);
      Node root = obj.constructTree(post, n);
      inorder(root);
      System.out.println();
    }
  }
}

// } Driver Code Ends

//User function Template for Java
/*class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

// Function should return the root of the bst formed using postorder traversal.
class GFG {

  GFG(int n) {}

  static class Index {

    int i;

    Index(int i) {
      this.i = i;
    }
  }

  static Node bstRecur(int post[], int n, Index index, int min, int max) {
    if (index.i < 0) return null;

    Node root = null;

    if (post[index.i] > min && post[index.i] < max) {
      root = new Node(post[index.i]);

      index.i = index.i - 1;

      root.right = bstRecur(post, n, index, root.data, max);

      root.left = bstRecur(post, n, index, min, root.data);
    }

    return root;
  }

  public static Node constructTree(int post[], int n) {
    //Add your code here.

    Index index = new Index(post.length - 1);

    return bstRecur(post, n, index, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
}
