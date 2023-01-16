class Solution {
    public int fib(int n) {

        // see also dp based approach
        
        if (n <= 1) return n;

        return fib(n - 1) + fib(n - 2);
    }

}