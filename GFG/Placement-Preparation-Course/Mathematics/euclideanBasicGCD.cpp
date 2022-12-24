#include<iostream>
using namespace std;

int gcd(int, int);

int main(){
    int a, b;
    
    cout << "Enter two Numbers :" << endl;
    cin >> a;
    cin >> b;

    int res = (a < b) ? gcd(a, b) : gcd(b, a);
    int lcm = (a * b) / (float)res;

    cout << "gcd(" << a << ", " << b << ") = " << res << endl;
    cout << "lcm(" << a << ", " << b << ") = " << lcm << endl;
    return 0;
}

int gcd(int a, int b){
    if(a == 0)
        return b;
    return gcd(b % a, a);
}