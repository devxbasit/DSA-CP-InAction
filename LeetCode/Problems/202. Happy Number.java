// https://leetcode.com/problems/happy-number/
class Solution {

    int happyUtil(int n) {

        int sum = 0;

        while (n > 0) {

            sum += Math.pow(n % 10, 2);
            n = n / 10;

        }

        return sum;

    }

    public boolean isHappy(int n) {

        // basically we have to detect cycle, we can use Floyd cycle detection algorithm

        int slow = happyUtil(n);
        int fast = happyUtil(happyUtil(n));

        if (fast == 1)
            return true;

        while (slow != fast) {

            if (fast == 1)
                return true;

            slow = happyUtil(slow);
            fast = happyUtil(happyUtil(fast));

        }

        return false;

    }
}