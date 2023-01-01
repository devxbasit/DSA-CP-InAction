
// https://practice.geeksforgeeks.org/problems/number-of-factors1435/1
class Solution {
    static int countFactors(int N) {
        // code here

        int factorCount = 0;

        for (int i = 1; i <= Math.sqrt(N); i++) {

            if (N % i == 0) {

                factorCount++;

                // check for prefect square, prevent duplicate mirror image
                // check for divisor and quotient
                if (N / i != i) {
                    factorCount++;
                }
            }
        }

        return factorCount;
    }
}
