// Initial template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends


// User function Template for C++

class Solution {
  public:
    vector<int> quadraticRoots(int a, int b, int c) {
        // code here
        vector<int> roots;
        int  D = (pow(b, 2) - (4 * a * c));

        if(D < 0){
            roots.push_back(-1); 
        }else{
            roots.push_back(floor(((-b) + sqrt(D)) / (2.0 * a)));
            roots.push_back(floor(((-b) - sqrt(D)) / (2.0 * a)));
        }   
        sort(roots.begin(), roots.end(), greater<int>()); 
        return roots;
    }
};

// { Driver Code Starts.

int main() {
    int T;
    cin >> T;
    while (T--) {
        int a, b, c;
        cin >> a >> b >> c;
        Solution ob;
        vector<int> roots = ob.quadraticRoots(a, b, c);
        if (roots.size() == 1 && roots[0] == -1)
            cout << "Imaginary";
        else
            for (int i = 0; i < roots.size(); i++) cout << roots[i] << " ";
        cout << endl;
    }
    return 0;
}  // } Driver Code Ends