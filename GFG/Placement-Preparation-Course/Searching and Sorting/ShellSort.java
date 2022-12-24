public class ShellSort {
    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void SSort(int arr[], int n){
        int gap = n / 2;
        
        while (gap >= 1){
            for (int i = 0, j = gap + i; j < n; i++, j++){
                if(arr[j] < arr[i])
                    swap(arr, i, j);
            }
            gap /= 2;
        }
    }
    public static void main(String[] args){
        int arr[] = {4, 3, 2, -10, 12, 1, 1, 5, 6};

        for (int n : arr)
            System.out.printf("%d \t", n);
        
        System.out.println("\nAfter Insertion Sort");
        SSort(arr, arr.length);

        for (int n : arr)
            System.out.printf("%d \t", n);
        
        System.out.println();
    }    
}
