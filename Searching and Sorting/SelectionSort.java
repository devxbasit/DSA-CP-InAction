class SelectionSort{

    public static void SSort(int arr[], int n){
        for (int i = 0; i < n - 1; i++){
            int minIndex = i;

            for (int j = i + 1; j < n; j++){
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
    public static void main(String[] args) {
        int arr[] = {4, 3, 2, -10, 12, 1, 1, 5, 6};

        
        for (int i : arr)
            System.out.printf("%d\t", i);

        System.out.printf("\nAfter Selection sort\n");
        
        SSort(arr, arr.length);

        for (int i : arr)
            System.out.printf("%d\t", i);

        System.out.println();       
    }
}