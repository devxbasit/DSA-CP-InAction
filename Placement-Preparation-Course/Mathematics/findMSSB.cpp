#include <iostream>
#include <math.h>

using namespace std;

int mostSignificantSetBit(int);
int mostSignificantSetBit2(int);
int mostSignificantSetBit3(int);
                                                                                                                             
int main(){
    int n;
    cout << "Enter value of  n\n";
    cin >> n;

    cout << "Output: " << mostSignificantSetBit(n) << endl;
    cout << "Output (method 2): " << mostSignificantSetBit2(n) << endl;
    cout << "Output (method 3): " << mostSignificantSetBit3(n) << endl;
    
    return 0;
}

int mostSignificantSetBit(int n){
    if (n == 0)
        return 0;

    int msb = -1;
    while (n > 0){
        n /= 2;
        msb++;
    }

    return (1 << msb);
}

int mostSignificantSetBit2(int n){
    n |= n >> 1;
    n |= n >> 2;
    n |= n >> 4;
    n |= n >> 8;
    n |= n >> 16;

    n += 1;

    return n >> 1;
}

int mostSignificantSetBit3(int n){
    int k = (int)log2(n); 
    return (int)(pow(2, k));
}