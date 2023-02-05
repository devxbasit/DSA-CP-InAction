// https://leetcode.com/problems/largest-number/
class Solution {
    public String largestNumber(int[] nums) {

        String S[] = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {

            S[i] = Integer.toString(nums[i]);

        }

        Arrays.sort(S, new Comparator<String>() {

            public int compare(String s1, String s2) {

                String a = s1 + s2;
                String b = s2 + s1;

                return b.compareTo(a);

            }
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < S.length; i++) {

            sb.append(S[i]);

        }

        if (sb.charAt(0) == '0') {

            return "0";

        }

        return sb.toString();

    }
}