// Given a number n the task is to complete the function which returns an integer denoting
// the smallest number evenly divisible by each number from 1 to n.
// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

long long getSmallestDivNum(long long n);

int main() {
	// your code goes here
	int t;
	cin>>t;
	while(t--)
	{
		int n;
		cin>>n;
		cout<<getSmallestDivNum(n)<<endl;
	}
	return 0;
	
}// } Driver Code Ends


/*You are required to complete this method */
long long getSmallestDivNum(long long n)
{
    //Your code here
    long long res = 1;
    
    for (long long i = 1; i <= n; i++)
        res = (res * i) / __gcd(res, i);
    
    return res;
}