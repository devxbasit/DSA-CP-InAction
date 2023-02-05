class BubbleSort{

    public static void BSort(int arr[], int n){
        for (int i = 0; i < n - 1; i++){
            int flag = 0;
            for (int j = 0; j < n - 1; j++ ){
                if (arr[j] > arr[j + 1]){
                    arr[j] += arr[j + 1];
                    arr[j + 1] = arr[j] - arr[j + 1];
                    arr[j] = arr[j] - arr[j + 1];

                    flag = 1;
                }
            }

            if (flag == 0)
                return ;
        }
    }
    public static void main(String[] args) {
        int arr[] = {4, 3, 2, -10, 12, 1, 1, 5, 6};
        
        for (int i : arr)
            System.out.printf("%d\t", i);

        System.out.printf("\nAfter Bubble sort\n");
        
        BSort(arr, arr.length);

        for (int i : arr)
            System.out.printf("%d\t", i);

        System.out.println();
        
    }
}