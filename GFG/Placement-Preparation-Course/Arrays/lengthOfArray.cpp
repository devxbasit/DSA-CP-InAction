#include<iostream>
using namespace std;

int main(){
    int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    char str[] = {'H', 'e', 'l', 'l', 'o'};
    char msg[] = "Hello world";

    cout << "length of arr[] is  " << *(&arr + 1) - arr << "\n";
    cout << "length of arr[] is  " << (int *)(&arr + 1) - arr << "\n";

    cout << "length of str[] is  " << *(&str + 1) - str << "\n";
    cout << "length of str[] is  " << (char *)(&str + 1) - str << "\n";

    cout << "length of msg is  " <<  *(&msg + 1) - msg << "\n";
    cout << "length of msg is  " <<  (char *)(&msg + 1) - msg << "\n";

    return 1;
}