// https://practice.geeksforgeeks.org/problems/bubble-sort/1

class Solution {
    // Function to sort the array using bubble sort algorithm.
    public static void bubbleSort(int arr[], int n) {
        // code here

        // check for base condition
        if (n == 1)
            return;

        boolean swapFlag = false;

        for (int i = 0; i < n - 1; i++) {

            if (arr[i] > arr[i + 1]) {

                swap(arr, i, i + 1);
                swapFlag = true;
            }
        }

        if (swapFlag == false)
            return;

        bubbleSort(arr, n - 1);

    }

    public static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}