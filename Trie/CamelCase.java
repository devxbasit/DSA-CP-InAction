//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    sc.nextLine();
		    String[] dict=sc.nextLine().split(" ");
		    String pattern=sc.nextLine();
		    findAllWords(dict,pattern);
		    System.out.println();
		    
		}
		
		
	}

 // } Driver Code Ends
//User function Template for Java


static class TrieNode {

    TrieNode childrens[];
    ArrayList<String> words;
    boolean isEnd;
    
    TrieNode() {
        
        childrens = new TrieNode[26];
        words = new ArrayList<String>();
        isEnd = false;
        
    }
    
}

static void insertNode(TrieNode root, String S) {
    
    
    TrieNode node = root;
    
    for (int level = 0; level < S.length(); level++) {
        
        if (Character.isLowerCase(S.charAt(level))) {
            
            continue;
        }
        
        
        if (node.childrens[S.charAt(level) - 'A'] == null) {
            
            node.childrens[S.charAt(level) - 'A'] = new TrieNode();
            
        }
        
        node = node.childrens[S.charAt(level) - 'A'];
        
    }
    
    node.isEnd = true;
    node.words.add(S);
    
}


static TrieNode getEndNode(TrieNode root, String pattern) {
    
    TrieNode node = root;
    
    for (int level = 0; level < pattern.length(); level++) {
        
        if (node.childrens[pattern.charAt(level) - 'A'] == null) {
            
            return null;
            
        }   
        
        node = node.childrens[pattern.charAt(level) - 'A'];
           
    }
    
    // below node can be null
    return node;
    
    
}
    
static void printRecur(TrieNode node) {
    
    if (node.isEnd == true) {
        
        for (String S : node.words) {
           
           System.out.print(S + " "); 
           
        }
        
    }
    

    for (int i = 0; i < node.childrens.length; i++) {
        
        if (node.childrens[i] != null) {
            
            printRecur(node.childrens[i]);
            
        }
    }
    
}


static void findAllWords(String[] dict, String pattern) 
{
    //Your code here
    
    TrieNode root = new TrieNode();
    
    Arrays.sort(dict);
    
    for (int i = 0; i < dict.length; i++) {
        
        insertNode(root, dict[i]);
        
    }
    
    TrieNode endNode = getEndNode(root, pattern);
    
    if (endNode == null) {
        
        System.out.printf("No match found");
        return;
    }
    
    
    printRecur(endNode);
    
} 

// { Driver Code Starts.


}
  // } Driver Code Ends