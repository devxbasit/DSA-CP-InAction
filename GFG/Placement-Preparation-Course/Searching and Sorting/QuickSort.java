public class QuickSort {
    public static int partition(int arr[], int low, int high){
        int pivot = arr[high];

        int i = low - 1;
        for (int j = low ; j <= high - 1; j++){
            if (arr[j] <= pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    
        arr[high] = arr[i + 1];
        arr[i + 1] = pivot;
        return i + 1;
    }
 
    public static void QSort(int arr[], int low, int high){
        if (low < high){
            int pIndex = partition(arr, low, high);
            QSort(arr, low, pIndex - 1);
            QSort(arr, pIndex + 1, high);
        }
    }
    public static void main(String[] args){
        int arr[] = {4, 3, 2, -10, 12, 1, 1, 5, 6};

        for (int n : arr)
            System.out.printf("%d \t", n);
        
        System.out.println("\nAfter Quick Sort");
        QSort(arr, 0,  arr.length - 1);

        for (int n : arr)
            System.out.printf("%d \t", n);
        
        System.out.println();
    }    
}
