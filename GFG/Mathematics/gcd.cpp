#include<iostream>
#include<math.h>
using namespace std;

int gcd(int, int);

int main(){
    int n1, n2;
    
    cout << "Enter two Numbers :" << endl;
    cin >> n1;
    cin >> n2;

    int res = gcd(n1, n2);
    int lcm = (n1 * n2) / (float)res;

    cout << "gcd(" << n1 << ", " << n2 << ") = " << res << endl;
    cout << "lcm(" << n1 << ", " << n2 << ") = " << lcm << endl;
    return 0;
}

int gcd(int n1, int n2){
    if (n1 < 0)
        n1 *= -1;

    if (n2 < 0)
        n2 *= -1;

    if (n2 % n1 == 0)
        return n1;

    if (n1 % n2 == 0)
        return n2;

    int i;
    int min = (n1 < n2) ? n1 : n2;
    int mid = min / 2;
    
    for (i = mid; i >= sqrt(min); i--)
        if (n1 % i == 0 && n2 % i == 0)
            return i;
    
    return 1;
}