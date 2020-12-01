import java.util.Scanner;

public class TernarySearch {
    public static int TSearch(int arr[], int lBound, int uBound, int key){
        if (lBound <= uBound){
            int mid1 = lBound + (uBound - lBound) /  3;
            int mid2 = uBound - (uBound - lBound) / 3;

            if (arr[mid1] == key)
                return mid1 + 1;

            if(arr[mid2] == key)
                return mid2 + 1;

            if (key < arr[mid1])
                return TSearch(arr, lBound, mid1 - 1, key);
            else if (key > arr[mid2])
                return TSearch(arr, mid2 + 1, uBound, key);

            return TSearch(arr, mid1 + 1, mid2 - 1, key);

            
        }

        return -1;
    }
    public static void main(String[] argss){
        int arr[] = {-10, 1, 3, 7, 9, 16, 25, 30, 33, 36, 45, 79};
        
        for (int i : arr)
            System.out.printf("%d\t", i);

        System.out.println("\nEnter key you want to search:\t");

        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();
        sc.close();

        int index = TSearch(arr, 0, arr.length - 1, key);
        
        if (index == -1)
            System.out.println("Key not found :-(");        
        else 
            System.out.printf("Key found at position %d\n", index);
    }    
}