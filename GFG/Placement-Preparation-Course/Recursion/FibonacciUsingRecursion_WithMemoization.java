import java.util.*;
import java.io.*;
import java.lang.*;

class FibonacciUsingRecursion_WithMemoization
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//taking total testcases
        
        while(t-- > 0)
        {
            int n = sc.nextInt();  // taking n as input
            System.out.println(new PrintFib().fibonacci(n)); // print the nth fibonacci number
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class PrintFib
{
    static long fib;
    static long arr[] = new long[21];
  
    
    static long fibonacci(int n)
    {
        // your code here
        
        if (n == 0)
            return 0;
        
        if (n == 1)
            return 1;
            
        long x = (arr[n - 1] == 0) ? arr[n - 1] = fibonacci(n - 1) : arr[n - 1];
        long y = (arr[n - 2] == 0) ? arr[n - 2] = fibonacci(n - 2) : arr[n - 2];
        
        return x + y;
    }
}


