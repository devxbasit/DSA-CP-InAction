// { Driver Code Starts
//Initial Template for C++


#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
//User function Template for C++

int digitsInFactorial(int N){
    // code here
    if(N < 0)
        return 0;
        
    if(N == 1)
        return 1;
    
    // kamenetsky's formula
    double d = (N * log10((N / M_E))) + (log10((2 * M_PI * N)) / 2.0);
    return floor(d + 1);
}

// { Driver Code Starts.

int main()
{
    int T;
    
    //taking testcases
    cin>>T;
    while(T--)
    {
        int N;
        
        //taking N
        cin>>N;
        
        //calling method digitsInFactorial()
        cout<<digitsInFactorial(N)<<endl;
    }
    return 0;
}
  // } Driver Code Ends