// https://leetcode.com/problems/roman-to-integer/
class Solution {

  public int romanToInt(String s) {
    HashMap<String, Integer> hm = new HashMap<>();

    hm.put("I", 1);
    hm.put("IV", 4);
    hm.put("V", 5);
    hm.put("IX", 9);

    hm.put("X", 10);
    hm.put("XL", 40);
    hm.put("L", 50);
    hm.put("XC", 90);
    hm.put("C", 100);

    hm.put("CD", 400);
    hm.put("D", 500);
    hm.put("CM", 900);
    hm.put("M", 1000);

    int sum = 0;

    for (int i = 0; i < s.length(); i++) {
      String curr = String.valueOf(s.charAt(i));
      String next = "";

      if (i < s.length() - 1) next = String.valueOf(s.charAt(i + 1));

      // chech if two combined digits forms a valid combination or not
      if (hm.containsKey(curr + next)) {
        sum += hm.get(curr + next);
        i++;
        continue;
      }

      sum += hm.get(curr);
    }

    return sum;
  }
}
