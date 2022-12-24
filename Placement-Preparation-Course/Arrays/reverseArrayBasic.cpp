#include<iostream>
using namespace std;
void reverse1(int[], int);
void reverse2(int[], int);
void reverse3(int[], int, int);

int main (){
    // rotate array counter-clockwise by 2
    int arr1[] = {1, 2, 3, 4, 5, 6};
    int arr2[] = {1, 2, 3, 4, 5, 6};
    int arr3[] = {1, 2, 3, 4, 5, 6};
    int n = *(&arr1 + 1) - arr1;

    reverse1(arr1, n);
    reverse2(arr2, n);
    reverse3(arr3, 0, n - 1);

    for (int i = 0; i < n; i++)
        cout << arr1[i] << "\t";

    cout << "\n";

    for (int i = 0; i < n; i++)
        cout << arr2[i] << "\t";

    cout << "\n";

    for (int i = 0; i < n; i++)
        cout << arr3[i] << "\t";

    return 0;
}

void reverse1(int arr[], int n){
    // TC - O(n)
    // SC - O(k)

    int temp[n];

    for (int i = 0; i < n; i++)
        temp[i] = arr[i];

    for (int i = 0, j = n - 1; i < n; i++, j--)
        arr[i] = temp[j];
}

void reverse2(int arr[], int n){
    // TC - O(n)
    // SC - O(1)

    for (int i = 0, j = n - 1; i < n / 2 ; i++, j--){
        arr[i] += arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] -= arr[j];
    }

}

void reverse3(int arr[], int start, int end){
    // TC - O(n)
    // SC - O(1)

    if (start >= end)
        return;

    int temp = arr[start];
    arr[start] = arr[end];
    arr[end] = temp;
    reverse3(arr, start + 1, end -1);
}
