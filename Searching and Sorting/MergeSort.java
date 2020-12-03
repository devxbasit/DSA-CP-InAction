public class MergeSort {
    public static void merge(int arr[], int low, int mid, int high){
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[low + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0;
        int j = 0;
        int k = low;

        while (i < n1 && j < n2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while(i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }

        while(j < n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    public static void MSort(int arr[], int low, int high){
        if (low < high){
            int mid = low + (high - low) / 2;
            MSort(arr, low, mid);
            MSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }
    public static void main(String[] args){
        int arr[] = {4, 3, 2, -10, 12, 1, 1, 5, 6};

        for (int n : arr)
            System.out.printf("%d \t", n);
        
        System.out.println("\nAfter Merge Sort");
        MSort(arr, 0,  arr.length - 1);

        for (int n : arr)
            System.out.printf("%d \t", n);
        
        System.out.println();
    }    
}