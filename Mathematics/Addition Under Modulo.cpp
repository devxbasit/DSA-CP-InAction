// You are given two numbers a and b. 
// You need to find the sum of a and b under modulo M (M = 109+7)

// { Driver Code Starts
//Initial Template for C++


#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends


//User function Template for C++


int sumUnderModulo(long long a,long long b)
{
    int M=1000000007;
    //your code here
    return ((a % M + b % M ) % M);
}

// { Driver Code Starts.


int main() {
	int T;
	
	//taking testcases
	cin>>T;
	while(T--)
	{
	    
	    long long a;
	    long long b;
	    
	    //taking input a and b
	    cin>>a>>b;
	    
	    //calling method sumUnderModulo()
	    cout<<sumUnderModulo(a,b)<<endl;
	}
	return 0;
}  // } Driver Code Ends