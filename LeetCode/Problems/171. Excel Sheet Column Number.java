// https://leetcode.com/problems/excel-sheet-column-number/
class Solution {

    public int titleToNumber(String s) {

        int toBaseTen = 0;

        int base = 26;

        for (int i = s.length() - 1, p = 0; i >= 0; i--, p++) {

            toBaseTen += (s.charAt(i) - 64) * Math.pow(base, p);

        }

        return toBaseTen;
    }
}