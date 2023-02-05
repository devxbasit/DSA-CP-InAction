// https://practice.geeksforgeeks.org/problems/merge-sort/1

class Solution {
    void merge(int arr[], int low, int mid, int high) {
        // Your code here

        int[] nums = new int[high - low + 1];

        int k = 0;
        int i = low;
        int j = mid + 1;

        while (i <= mid && j <= high) {

            if (arr[i] < arr[j]) {
                nums[k] = arr[i];
                i++;

            } else {
                nums[k] = arr[j];
                j++;

            }

            k++;
        }

        while (i <= mid) {
            nums[k] = arr[i];
            k++;
            i++;
        }

        while (j <= high) {
            nums[k] = arr[j];
            k++;
            j++;
        }

        for (int l = 0; l < nums.length; l++) {
            arr[l + low] = nums[l];
        }

    }

    void mergeSort(int arr[], int low, int high) {
        // code here

        if (low == high)
            return;

        int mid = low + (high - low) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        merge(arr, low, mid, high);

    }
}
