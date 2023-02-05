// https://leetcode.com/problems/find-smallest-letter-greater-than-target/
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {

        if (letters[letters.length - 1] <= target)
            return letters[0];

        int low = 0;
        int high = letters.length - 1;

        char res = '-';

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (letters[mid] > target) {

                res = letters[mid];
                high = mid - 1;

            } else {

                // else if less than or equal to

                low = mid + 1;

            }

        }

        return res;

    }
}