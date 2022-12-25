#include<iostream>
using namespace std;

void prefixSum(int[], int, int []);
int sumInRange(int[], int, int, int);

int main(){
    int arr[] = {10, 5, 1, 20, 40};
    int n = *(&arr + 1) - arr;
    int prefixArr[n];

    for (int i = 0; i < n; i++ )
        cout << arr[i] << "\t";
    
    cout << "\nsum in range[index] i - j\nEnter values of i and j :\t";
    int i, j;
    cin  >> i >> j;


    prefixSum(arr, n, prefixArr);

    cout << "\nPrefix sum Arrray:\n";
    for (int i = 0; i < n; i++ )
        cout << prefixArr[i] << "\t";
    
    cout << "\nsum in range " << i << " - " << j << " = " << sumInRange(prefixArr, n, i, j) << "\n"; 


}

void prefixSum(int arr[], int n, int prefixArr[]){
    prefixArr[0] = arr[0];
    for (int i = 1; i < n; i++ )
        prefixArr[i] = prefixArr[i -1] + arr[i];
}

int sumInRange(int prefixArr[], int n, int i, int j){
    if (i == 0)
        return prefixArr[j];
    else
        return prefixArr[j] - prefixArr[i - 1];   
}