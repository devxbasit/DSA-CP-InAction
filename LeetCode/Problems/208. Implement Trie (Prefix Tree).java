class TrieNode {
  
    TrieNode childrens[];
    boolean isEndOfWord;
    
    /** Initialize your data structure here. */
    public TrieNode() {
        
        childrens = new TrieNode[26];
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(TrieNode root, String word) {
        
        if (word.length() == 0) return;
        
        TrieNode node = root;
        
        for (int i = 0; i < word.length(); i++) {
            
            int index = word.charAt(i) - 'a';
            
            if (node.childrens[index] == null) {
                
                node.childrens[index] = new TrieNode();
                
            }
            
            node = node.childrens[index];
        }
        
        node.isEndOfWord = true;
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(TrieNode root, String word) {
        
        TrieNode node = root;
        
        for (int i = 0; i < word.length(); i++) {
            
            int index = word.charAt(i) - 'a';
            
            if (node.childrens[index] == null) return false;
            
            node = node.childrens[index];
            
        }
        
        return node != null && node.isEndOfWord;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(TrieNode root, String prefix) {
        
        TrieNode node = root;
        
        for (int i = 0; i < prefix.length(); i++) {
            
            int index = prefix.charAt(i) - 'a';
            
            if (node.childrens[index] == null) return false;
            
            node = node.childrens[index];
            
        }
        
        return node != null;
               
    }
}


class Trie {

    TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        
        root = new TrieNode();
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        root.insert(root, word);

    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        return root.search(root, word);
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
               
        return root.startsWith(root, prefix);
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */