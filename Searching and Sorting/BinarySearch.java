import java.util.Scanner;

public class BinarySearch {
    public static int BSearch(int arr[], int lBound, int uBound, int key){
        if (lBound <= uBound){
            int mid = lBound + (uBound - lBound) / 2;
            
            if (arr[mid] == key)
            return mid + 1;
            
            if (key < arr[mid])
                return BSearch(arr, lBound, mid - 1, key);
                
            return BSearch(arr, mid + 1, uBound, key);
        }

        return -1;
    }
    public static void main(String[] argss){
        int arr[] = {-10, 1, 3, 7, 9, 16, 25, 30};
        
        for (int i : arr)
            System.out.printf("%d\t", i);

        System.out.println("\nEnter key you want to search:\t");

        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();
        sc.close();
        

        int index = BSearch(arr, 0, arr.length - 1, key);
        
        if (index == -1)
            System.out.println("Key not found :-(");        
        else 
            System.out.printf("Key found at position %d\n", index);
    }    
}