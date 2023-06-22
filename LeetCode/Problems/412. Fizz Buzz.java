// https://leetcode.com/problems/fizz-buzz/
class Solution {

  public List<String> fizzBuzz(int n) {
    List<String> list = new ArrayList<>();

    for (int i = 1; i <= n; i++) {
      boolean three = (i % 3 == 0) ? true : false;
      boolean five = (i % 5 == 0) ? true : false;

      String S = "";

      if (three) S = "Fizz";
      if (five) S += "Buzz";

      if (S.equals("")) S = String.valueOf(i);

      list.add(S);
    }

    return list;
  }
}
