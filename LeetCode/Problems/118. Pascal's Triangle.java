// https://leetcode.com/problems/pascals-triangle/
class Solution {

  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> triangle = new ArrayList<>();

    triangle.add(Arrays.asList(1));

    if (numRows == 1) return triangle;

    for (int i = 1; i < numRows; i++) {
      List<Integer> prevRow = triangle.get(i - 1);

      List<Integer> newRow = new ArrayList<>();

      newRow.add(1);

      for (int j = 1; j < prevRow.size(); j++) {
        newRow.add(prevRow.get(j) + prevRow.get(j - 1));
      }

      newRow.add(1);
      triangle.add(newRow);
    }

    return triangle;
  }
}
