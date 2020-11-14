#include <iostream>
using namespace std;

int setBit(int, int);

int main(){
    int n, k;
    cout << "Enter values of  n and k\n";
    cin >> n;
    cin >> k;

    cout << "Output: " << setBit(n, k) << endl;
    
    return 0;
}

int setBit(int n, int k){
    return (n | (1 << (k - 1)));
}
