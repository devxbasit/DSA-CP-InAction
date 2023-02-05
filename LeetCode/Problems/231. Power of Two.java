// https://leetcode.com/problems/power-of-two/
class Solution {
    public boolean isPowerOfTwo(int n) {

        /*
         * method1
         * 
         * if (n == 0) return false;
         * 
         * // 2^0 = 1
         * // 2^1 = 2
         * // ..
         * // 2^x = n;
         * 
         * // powers of two are 1, 2, 4, 8, ...
         * 
         * while (n % 2 == 0) {
         * 
         * n = n / 2;
         * 
         * 
         * }
         * 
         * return n == 1;
         * 
         */

        /*
         * method2 - only 1 bit should be set
         * 
         */

        if (n < 1)
            return false;

        n = n & (n - 1);

        return n == 0;

        /*
         * method 3
         * 
         * calcutate log N to the base 2
         * if that is equal to 1.0, 4.0, 8.0 or anything but should be in form x.0
         * 
         * loga b = log10 b / log10 a
         * 
         * /*
         * 
         * /*
         * do not work on input 536870912
         * if (n == 0) return false;
         * 
         * double logBase2 = Math.log(n) / Math.log(2);
         * 
         * return (int)(Math.floor(logBase2)) == (int)(Math.ceil(logBase2));
         */
    }
}