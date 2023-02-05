// https://leetcode.com/problems/contains-duplicate/
class Solution {
    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> hs = new HashSet<>();

        for (int i : nums) {

            if (hs.contains(i))
                return true;

            hs.add(i);
        }

        return false;

        // another method with not extra space
        // sort and start comparing i with i + 1;

        // if i ranges between 0 - (arr.length - 1) , mark arr[arr[i]] negative, (index
        // based marking)

    }
}