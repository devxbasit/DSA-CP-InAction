class Solution{
    static long sumOfDivisors(int N){
        // code here
        // https://www.youtube.com/watch?v=tDM6lT-qjys
        
        long sum = 0;
        
        for (int i = 1; i <= N; i++)  {
            sum += (N / i) * i;
        }
        
        return sum;
    }
}