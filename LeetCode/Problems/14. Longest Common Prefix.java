// https://leetcode.com/problems/longest-common-prefix/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        
        
        int i;
        String firstWord = strs[0];
        
        outerloop:
        for (i = 0 ; i < firstWord.length(); i++ ) {
        
            for (String s : strs) {
                
                if (i >= s.length()) break outerloop;
                
                if (s.charAt(i) != firstWord.charAt(i)) break outerloop;
                
            }
            
        }
        
        if (i == 0) return "";
        
        return firstWord.substring(0, i);
        
        // we can also solve it using TRIE 
        
    }
}