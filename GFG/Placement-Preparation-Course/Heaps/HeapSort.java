import java.util.*;
class Heap_Sort
{
    void printArray(int arr[],int n)
    {
        //int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc  = new Scanner(System.in);
        Heap_Sort hs = new Heap_Sort();
        int arr[] = new int[1000000];
        int T = sc.nextInt();
        while(T>0)
        {
            int n = sc.nextInt();
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
            hs.heapSort(arr,n);
            hs.printArray(arr,n);
            T--;
        }
    }
    public void heapSort(int arr[], int n)
    {
        GfG g = new GfG();
        g.buildHeap(arr, n);
        for (int i=n-1; i>=0; i--)
        {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            g.heapify(arr, i, 0);
        }
    }
}


// } Driver Code Ends


class GfG
{
    void buildHeap(int arr[], int n)
    {
        // Your code here
        // parent of last node = last non leaf node
        int lastNonLeafNodeIndex = ((n - 1) - 1) / 2;
        
        for (int i = lastNonLeafNodeIndex; i >= 0; i--)
            heapify(arr, n, i);
    }
    
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    
    void swap (int arr[], int i, int j){
        
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
    }
    
    void heapify(int arr[], int n, int i){
        // Your code here
        
        // tickleDown
        
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        int largest = i;
        
        if (left < n && arr[left] > arr[largest])
            largest = left;
            
        if (right < n && arr[right] > arr[largest])
            largest = right;
            
        if (largest != i){
            
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }
 }
 
 