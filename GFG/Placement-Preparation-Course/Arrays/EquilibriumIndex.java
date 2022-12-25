public class EquilibriumIndex {

    public static int equilibriumIndex (int arr[]){
        int n = arr.length;
        int sum = 0;
        
        for (int i : arr)
            sum += i;
        
        int leftSum = 0;
        for (int i = 0; i < n - 1; i++){
            sum -= arr[i];
            if(leftSum == sum)
                return i;
                
            leftSum += arr[i];
        }
        return -1;
}

    public static void main(String[] args) {
        int arr[] = {-7, 1, 5, 2, -4, 3, 0};
        
        for (int i : arr)
            System.out.printf("%d \t", i);

        System.out.println("\nEquilibrium Index = " + equilibriumIndex(arr));
    }
}
