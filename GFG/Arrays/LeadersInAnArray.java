// { Driver Code Starts
import java.io.*;
import java.util.*;

class Array {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases

    while (t-- > 0) {
      //input size of array
      int n = Integer.parseInt(br.readLine().trim());
      int arr[] = new int[n];
      String inputLine[] = br.readLine().trim().split(" ");

      //inserting elements in the array
      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(inputLine[i]);
      }

      Leader obj = new Leader();

      StringBuffer str = new StringBuffer();
      ArrayList<Integer> res = new ArrayList<Integer>();

      //calling leaders() function
      res = obj.leaders(arr, n);

      //appending result to a String
      for (int i = 0; i < res.size(); i++) {
        str.append(res.get(i) + " ");
      }

      //printing the String
      System.out.println(str);
    }
  }
}

// } Driver Code Ends

class Leader {

  static ArrayList<Integer> leaders(int arr[], int n) {
    // Your code here
    ArrayList<Integer> leadersList = new ArrayList<Integer>();

    int maxElement = arr[n - 1];

    for (int i = n - 1; i >= 0; i--) if (arr[i] >= maxElement) {
      leadersList.add(arr[i]);
      maxElement = arr[i];
    }

    Collections.reverse(leadersList);
    return leadersList;
  }
}
