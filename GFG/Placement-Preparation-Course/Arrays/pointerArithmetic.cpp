#include<iostream>
using namespace std;

int main (){
    int arr[] = {1, 2, 3, 4, 5};
    int *ptr_arr = arr;

    // ***
    // https://www.geeksforgeeks.org/whats-difference-between-array-and-array-for-int-array5/
    // "arr” is a “pointer to the first element of array” but 
    // “&arr” is a “pointer to whole array of 5 int”.

    cout << "size of arr - " << sizeof(arr) << "\n";
    cout << "size of arr[0] - " << sizeof(arr[0]) << "\n";
    cout << "size of *ptr_arr - " << sizeof(*ptr_arr) << "\n";
    cout << "&arr - " << arr << "\n";
    cout << "&arr[0] - " << &arr[0] << "\n";
    cout << "arr - " << arr << "\n";
    cout << "ptr_arr - " << ptr_arr << "\n";

    cout << "(arr + 1) - " << (arr + 1) << "\n";
    cout << "(&arr + 1) - " << (&arr + 1) << "\n";
    cout << "(ptr_arr + 1) - " << (ptr_arr + 1) << "\n\n";

    int n = 1;
    int *ptr_n = &n;
    cout << "size of int - " << sizeof(int) << "\n";
    cout << "&n - " << &n << "\n";
    cout << "ptr_n - " << ptr_n << "\n";
    cout << "(&n + 1) - " << (&n + 1) << "\n";
    cout << "(ptr_n + 1) - " << (ptr_n + 1) << "\n\n";



    float PI = 3.14;
    float *ptr_PI = &PI; 
    cout << "size of float - " << sizeof(float) << "\n";
    cout << "&PI - " << &PI << "\n";
    cout << "ptr_PI - " << ptr_PI << "\n";
    cout << "(&PI + 1) - " << (&PI + 1) << "\n";
    cout << "(ptr_PI + 1) - " << (ptr_PI + 1) << "\n\n";

    char ch = 'a';  
    char *ptr_ch = &ch;
    cout << "size of char - " << sizeof(char) << "\n";
    cout << "&ch - " << &ch << "\n";
    cout << "ptr_ch - " << ptr_ch << "\n";
    cout << "(&ch + 1) - " << (&ch + 1) << "\n";
    cout << "(ptr_ch + 1) - " << (ptr_ch + 1) << "\n\n";
}   