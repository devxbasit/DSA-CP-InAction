// https://leetcode.com/problems/longest-palindromic-substring/
class Solution {
    int maxLen = 0;
    int beginIndex;
    
    public void expandRange(String s, int begin, int end){
        while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)){
            begin--;
            end++;
        }
        
        if (maxLen < end - begin - 1){
            maxLen = end - begin - 1;
            beginIndex = begin + 1;
        }
    }   
    
    public String longestPalindrome(String s) {
        
        if (s.length() < 2)
            return s;
        
        for (int start = 0; start < s.length() - 1; start++){
            expandRange(s, start, start);
            expandRange(s, start, start + 1);
        }
        
        // start index is inclusive and end index is exclusive
        return s.substring(beginIndex, beginIndex + maxLen);
    }
}