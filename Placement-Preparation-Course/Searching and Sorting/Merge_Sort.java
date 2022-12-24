import java.util.*;

class Merge_Sort
{
    //method to print the elements of the array
	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    //method for dividing the array into halves
    static void mergeSort(int arr[], int l, int r)
    {
        GfG g = new GfG();
        if (l < r)
        {
            int m = (l+r)/2;
            mergeSort(arr, l, m);
            mergeSort(arr , m+1, r);
            g.merge(arr, l, m, r);
        }
    }

	public static void main(String args[])
	{
	    //taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking testcases
		int T = sc.nextInt();
		while(T>0)
		{
		    //taking elements count
			int n = sc.nextInt();
			
			//creating an object of class Merge_Sort
			Merge_Sort ms = new Merge_Sort();
			
			//creating an array of size n
			int arr[] = new int[n];
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();

            
			GfG g = new GfG();
			
			//calling the method mergeSort
			mergeSort(arr,0,arr.length-1);

            //calling the method printArray
			ms.printArray(arr);
		T--;
		}
	}
}


// } Driver Code Ends

class GfG
{
    void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
         
        int A[] = new int[n1];
        int B[] = new int[n2];
         
        for (int i = 0; i < n1; i++)
            A[i] = arr[l + i];
            
        for (int j = 0; j < n2; j++)
            B[j] = arr[m + j + 1];
        
        int i = 0;
        int j = 0;
        int k = l;
        
        while (i < n1 && j < n2){
            if(A[i] < B[j])
                arr[k] = A[i++];
            else
                arr[k] = B[j++];
                
            k++;
        }
        
        while(i < n1)
            arr[k++] = A[i++];
        
        while(j < n2)
            arr[k++] = B[j++];
    }
}
