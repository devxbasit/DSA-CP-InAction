public class CountingSort {
        public static void CSort(int arr[], int n){
            
            int k = arr[0];
            for (int i = 1; i < n; i++)
                if (arr[i] > k)
                    k = arr[i];
            k++;
            int FreqArr[] = new int [k];
            
            for (int i = 0; i < n; i++)
                ++FreqArr[arr[i] - 1];
            
            for (int i = 1; i < k; i++)
                FreqArr[i] += FreqArr[i - 1];

            int temp[] = new int[n];
            for (int i = 0; i < n; i++)
                    temp[i] = arr[i];
    
            for (int i = 0; i < n; i++){
                arr[FreqArr[temp[i] - 1] - 1] = temp[i];
                FreqArr[temp[i] - 1] -= 1;  
            }
        }
        public static void main(String[] args){
            int arr[] = {4, 2, 2, 1, 5, 3};
    
            for (int n : arr)
                System.out.printf("%d \t", n);
            
            System.out.println("\nAfter Counting Sort");
            CSort(arr, arr.length);
    
            for (int n : arr)
                System.out.printf("%d \t", n);
            
            System.out.println();
        }    
    }