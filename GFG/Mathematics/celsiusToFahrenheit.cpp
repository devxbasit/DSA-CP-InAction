//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;


 // } Driver Code Ends


//User function Template for C++


//You need to complete this function
double cToF(int C)
{
    //Your code here
    // F = C * 9 / 2 + 32
    // return ((double)(C) * 9.0 /  5.0) + 32.0;
    return ((C * 9) / 5) + 32;
}

// { Driver Code Starts.







int main()
{
    int T;//number of testcases
    int C,F;
    cin >> T; //input number of testcases
    while(T--){
        cin >> C;//input temperature in celscius
        cout << floor(cToF(C)) << endl; //print the output
    }
    return 0;
}  // } Driver Code Ends