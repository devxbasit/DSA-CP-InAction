// https://leetcode.com/problems/climbing-stairs/
class Solution {

    public int climbStairs(int n) {

        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        int dp[] = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < dp.length; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        return dp[dp.length - 1];

        // can be solved using fibonnacci
        // Fib(n) = Fib(n − 1) + Fib(n − 2)

    }
}
