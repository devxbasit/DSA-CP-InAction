class Solution {
    static Long[] lcmAndGcd(Long A, Long B) {
        // code here

        long gcd = Gcd(A, B);
        long lcm = (A * B) / gcd;

        return new Long[] { lcm, gcd };
    }

    public static long Gcd(long a, long b) {

        if (b == 0)
            return a;

        return Gcd(b, a % b);
    }
}