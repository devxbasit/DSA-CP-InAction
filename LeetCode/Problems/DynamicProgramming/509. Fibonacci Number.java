class Solution {
    public int fib(int n) {

        // constraints( 0 <= n <= 30 )

        int dp[] = new int[31];

        Arrays.fill(dp, -1);

        return dpFib(dp, n);

    }

    public int dpFib(int dp[], int n) {

        if (n <= 1)
            return dp[n] = n;

        if (dp[n] != -1)
            return dp[n];

        return dp[n] = dpFib(dp, n - 1) + dpFib(dp, n - 2);
    }
}
