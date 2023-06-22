//Initial template for Java

import java.io.*;
import java.util.*;

class SortAnArrayOfZeorsOnesTwos_2 {

  // } Driver Code Ends

  //User function template for Java
  public static void swap(int arr[], int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void sort012(int a[], int n) {
    // code here
    int low = 0;
    int mid = 0;
    int high = n - 1;

    while (mid <= high) {
      if (a[mid] == 0) {
        swap(a, low, mid);
        low++;
        mid++;
      } else if (a[mid] == 2) {
        swap(a, mid, high);
        high--;
      } else mid++;
    }
  }

  // { Driver Code Starts.

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
    while (t-- > 0) {
      int n = Integer.parseInt(br.readLine().trim());
      int arr[] = new int[n];
      String inputLine[] = br.readLine().trim().split(" ");
      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(inputLine[i]);
      }
      sort012(arr, n);
      StringBuffer str = new StringBuffer();
      for (int i = 0; i < n; i++) {
        str.append(arr[i] + " ");
      }
      System.out.println(str);
    }
  }
}
// } Driver Code Ends
