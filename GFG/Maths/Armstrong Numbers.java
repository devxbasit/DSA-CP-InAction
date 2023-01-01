class Solution {
    static String armstrongNumber(int n){
        // code here
        
        int temp = n;
        int sum = 0;
        
        while (n != 0) {
            
            sum += Math.pow(n % 10, 3);
            n /= 10;
            
        }
        
        return sum == temp ? "Yes" : "No";
    }
}1