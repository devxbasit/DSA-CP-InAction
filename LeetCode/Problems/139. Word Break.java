// https://leetcode.com/problems/word-break/
class Solution {

  public boolean helperRecur(
    HashSet<String> hs,
    HashSet<String> visited,
    String S
  ) {
    if (visited.contains(S)) return false;

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < S.length(); i++) {
      sb.append(S.charAt(i));

      if (hs.contains(sb.toString())) {
        if (i == S.length() - 1) return true;

        if (
          helperRecur(hs, visited, S.substring(i + 1, S.length()))
        ) return true;
      }
    }

    visited.add(S);
    return false;
  }

  public boolean wordBreak(String s, List<String> wordDict) {
    HashSet<String> hs = new HashSet<>();
    HashSet<String> visited = new HashSet<>();

    for (String word : wordDict) {
      hs.add(word);
    }

    if (hs.contains(s)) return true;

    return helperRecur(hs, visited, s);
  }
}
