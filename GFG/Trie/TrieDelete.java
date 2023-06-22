import java.util.*;

class TrieNode {

  char content;
  boolean isEnd;
  int count;
  LinkedList<TrieNode> childList;

  public TrieNode(char c) {
    childList = new LinkedList<TrieNode>();
    isEnd = false;
    content = c;
    count = 0;
  }

  public TrieNode subNode(char c) {
    if (childList != null) for (TrieNode eachChild : childList) if (
      eachChild.content == c
    ) return eachChild;
    return null;
  }
}

public class TrieTest {

  private static TrieNode root;

  TrieTest() {
    root = new TrieNode(' ');
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      TrieTest z = new TrieTest();
      Solution g = new Solution();
      int n = sc.nextInt();
      ArrayList<String> keys = new ArrayList<String>();
      for (int i = 0; i < n; i++) {
        keys.add(sc.next());
      }
      for (int i = 0; i < keys.size(); i++) {
        insert(keys.get(i));
      }
      String abc = sc.next();
      g.deleteKey(root, abc.toCharArray());
      if (ifExsist(abc) == false) System.out.println(
        "1"
      ); else System.out.println("0");
    }
  }

  public static boolean ifExsist(String word) {
    TrieNode current = root;
    for (char ch : word.toCharArray()) {
      if (current.subNode(ch) == null) return false; else current =
        current.subNode(ch);
    }
    if (current.isEnd == true) return true;
    return false;
  }

  public static void insert(String word) {
    if (ifExsist(word) == true) return;
    TrieNode current = root;
    for (char ch : word.toCharArray()) {
      TrieNode child = current.subNode(ch);
      if (child != null) current = child; else {
        current.childList.add(new TrieNode(ch));
        current = current.subNode(ch);
      }
      current.count++;
    }
    current.isEnd = true;
  }
} // } Driver Code Ends

/*Complete the function below
Node is as follows:
class TrieNode 
{
    char content; 
    boolean isEnd; 
    int count;  
    LinkedList<TrieNode> childList; 
    public TrieNode(char c)
    {
        childList = new LinkedList<TrieNode>();
        isEnd = false;
        content = c;
        count = 0;
    }  
    
    public TrieNode subNode(char c)
    {
        if (childList != null)
            for (TrieNode eachChild : childList)
                if (eachChild.content == c)
                    return eachChild;
        return null;
    }
}*/

class Solution {

  static boolean deleteRecur(TrieNode node, char key[], int level) {
    if (node == null) {
      return false;
    }

    if (level >= key.length) {
      if (node.isEnd == false) {
        return false;
      }

      node.isEnd = false;

      return node.childList.size() == 0;
    } else {
      TrieNode child = node.subNode(key[level]);

      if (deleteRecur(child, key, level + 1)) {
        node.childList.remove(child);

        return node.childList.size() == 0;
      }

      return false;
    }
  }

  public static void deleteKey(TrieNode root, char[] key) {
    //add code here.

    if (root == null) {
      return;
    }

    deleteRecur(root, key, 0);
  }
}
