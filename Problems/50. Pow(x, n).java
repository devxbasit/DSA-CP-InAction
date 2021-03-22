class Solution {
    
    
    // https://www.youtube.com/watch?v=snOaKR2xgZg&ab_channel=KnowledgeCenter
    
    public double myPowUtil(double x, long n) {
        
        if (n == 0) return 1.0;
        if (n == 1) return x;
        
        if (n < 0) return myPowUtil(1.0 / x, -n);
        
        return myPowUtil(x * x, n / 2) * ((n % 2 == 1) ? x : 1);
    
    }
    
    public double myPow(double x, int n) {
        
        return myPowUtil(x, n);
        
    }
    
}