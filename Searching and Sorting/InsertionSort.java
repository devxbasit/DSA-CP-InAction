public class InsertionSort {
    public static void ISort(int arr[], int n){
        for (int i = 1; i < n; i++){
                       
            int j = i - 1;
            int temp = arr[i];

            while (j >= 0  && temp < arr[j]){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }
    public static void main(String[] argss){
        int arr[] = {4, 3, 2, -10, 12, 1, 5, 6};

        for (int n : arr)
            System.out.printf("%d \t", n);
        
        System.out.println("\nAfter Insertion Sort");
        ISort(arr, arr.length);

        for (int n : arr)
            System.out.printf("%d \t", n);
        
        System.out.println();
    }    
}
