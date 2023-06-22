import java.util.*;

class suffix {

  int index;
  int rank[] = new int[2];
}

class UniqueSubStr {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while (t-- > 0) {
      String st = sc.next();
      GfG g = new GfG();
      System.out.println(g.countDistinctSubstring(st));
    }
  }
} // } Driver Code Ends

/*You are required to complete this method */
class GfG {

  static class TrieNode {

    TrieNode childrens[];
    boolean isEnd;

    TrieNode() {
      childrens = new TrieNode[26];

      isEnd = false;
    }
  }

  static void insertString(TrieNode root, String S) {
    TrieNode node = root;

    for (int level = 0; level < S.length(); level++) {
      if (node.childrens[S.charAt(level) - 'a'] == null) {
        node.childrens[S.charAt(level) - 'a'] = new TrieNode();
      }

      node = node.childrens[S.charAt(level) - 'a'];
    }

    node.isEnd = true;
  }

  static int countNodes(TrieNode root) {
    int count = 0;

    for (int i = 0; i < root.childrens.length; i++) {
      if (root.childrens[i] != null) {
        count += countNodes(root.childrens[i]);
      }
    }

    return count + 1;
  }

  public static int countDistinctSubstring(String S) {
    //your code here

    TrieNode root = new TrieNode();

    for (int i = 0; i < S.length(); i++) {
      insertString(root, S.substring(i));
    }

    return countNodes(root);
  }
}
