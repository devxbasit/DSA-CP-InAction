//Initial Template for Java

import java.io.*;
import java.io.*;
import java.util.*;

public abstract class MergeWithoutExtraSpace_1 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
    while (t-- > 0) {
      String inputLine[] = br.readLine().trim().split(" ");
      int n = Integer.parseInt(inputLine[0]);
      int m = Integer.parseInt(inputLine[1]);
      int arr1[] = new int[n];
      int arr2[] = new int[m];
      inputLine = br.readLine().trim().split(" ");
      for (int i = 0; i < n; i++) {
        arr1[i] = Integer.parseInt(inputLine[i]);
      }
      inputLine = br.readLine().trim().split(" ");
      for (int i = 0; i < m; i++) {
        arr2[i] = Integer.parseInt(inputLine[i]);
      }

      new MergeSort().merge(arr1, arr2, n, m);

      StringBuffer str = new StringBuffer();
      for (int i = 0; i < n; i++) {
        str.append(arr1[i] + " ");
      }
      for (int i = 0; i < m; i++) {
        str.append(arr2[i] + " ");
      }
      System.out.println(str);
    }
  }
}

// } Driver Code Ends

//User function Template for Java

class MergeSort {

  public static void merge(int arr1[], int arr2[], int n, int m) {
    // code here
    int i, index;
    int temp;

    for (int j = m - 1; j >= 0; j--) {
      i = -1;
      index = -1;

      while (++i < n) if (arr1[i] > arr2[j]) {
        index = i;
        break;
      }

      if (index != -1) {
        temp = arr2[j];
        arr2[j] = arr1[n - 1];

        for (int k = n - 1; k > index; k--) arr1[k] = arr1[k - 1];

        arr1[index] = temp;
      }
    }
  }
}
