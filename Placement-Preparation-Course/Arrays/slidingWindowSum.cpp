#include<iostream>
using namespace std;

int sum(int [], int, int);

int main(){
    int arr[] = {4, 2, -3, 2, 5, 2, 9, -6, 13, 7};
    int k;
    int n = *(&arr + 1) - arr;
    for (int i = 0; i < n; i++ )
        cout << arr[i] << "\t";
    
    cout << "\nMax sum of K blocks\nEnter value of K :\t";
        cin >> k;
    
    cout << "\nWindow size =" << k << "\nMax sum = " << sum(arr, n, k) << "\n";
}

int sum(int arr[], int n, int k){
    int max_window_sum = 0;
    int current_window_sum = 0;
    
    for (int i = 0; i < k; i++)
        max_window_sum += arr[i];
    
    current_window_sum = max_window_sum;
    for(int i = 0; i < n - k; i++){
        current_window_sum = (current_window_sum - arr[i]) + arr[i + k];

        if (max_window_sum < current_window_sum)
            max_window_sum = current_window_sum;
    }
    
    return max_window_sum;
}