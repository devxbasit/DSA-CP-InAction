//Initial template for Java

import java.io.*;
import java.util.*;

class SortAnArrayOfZeorsOnesTwos_1 {
    
 // } Driver Code Ends


//User function template for Java

public static void sort012(int a[], int n){
    // code here 
    int x = 0;
    int y = 0;
    int z = 0;
    
    for (int i = 0; i < n; i++){
        if(a[i] == 0)
            x++;
            
        if(a[i] == 1)
            y++;
            
        if(a[i] == 2)
            z++;
    }
    
    for (int i = 0; i < n; i++){
        if (x > 0){
            a[i] = 0;
            x--;
        }else if (y > 0){
            a[i] = 1;
            y--;
        }else {
            a[i] = 2;
            z--;
        }
    }
}


// { Driver Code Starts.

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}

  // } Driver Code Ends