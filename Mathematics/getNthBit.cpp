#include <iostream>
using namespace std;

int getNthBit(int, int);

int main(){
    int n, k;
    cout << "Enter values of  n and k\n";
    cin >> n;
    cin >> k;

    cout << "Output: " << getNthBit(n, k) << endl;
    
    return 0;
}

int getNthBit(int n, int k){
    return (0 == (n & (1 << (k - 1)))) ? 0 : 1;
}
