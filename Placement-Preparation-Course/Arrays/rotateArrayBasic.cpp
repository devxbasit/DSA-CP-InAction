#include<iostream>
using namespace std;
void rotateLeft1(int[], int, int);
void rotateLeft2(int[], int, int);

int main (){
    // rotate array counter-clockwise by 2
    int arr1[] = {1, 2, 3, 4, 5, 6};
    int arr2[] = {1, 2, 3, 4, 5, 6};
    int k;
    cout << "Left Rotate Array by K steps\nEnter Value for K :\t";
    cin >> k;
    int n = *(&arr1 + 1) - arr1;

    rotateLeft1(arr1, n, k);
    rotateLeft2(arr2, n, k);

    for (int i = 0; i < n; i++)
        cout << arr1[i] << "\t";

    cout << "\n";

    for (int i = 0; i < n; i++)
        cout << arr2[i] << "\t";

    return 0;
}

void rotateLeft1(int arr[], int n, int k){
    // TC - O(n)
    // SC - O(k)

    int temp[k];

    for (int i = 0; i < k; i++)
        temp[i] = arr[i];

    for (int i = 0; i < n - k; i++)
        arr[i] = arr[i + k]; 
    
    for (int i = 0, j = n - k; j < n; i++, j++)
        arr[j] = temp[i];
}

void rotateLeft2(int arr[], int n, int k){
    // TC - O(n*k)
    // SC - O(1)
    int temp;

    for (int i = 0; i < k; i++){
        temp = arr[0];
        for (int j = 0; j < n - 1; j++)
            arr[j] = arr[j + 1];
        arr[n - 1] = temp;
    }
}