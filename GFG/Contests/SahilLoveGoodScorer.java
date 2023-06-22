/*package whatever //do not write package name here */

import java.io.*;
import java.lang.*;
import java.util.*;

/*
Sahil is in the mood to attend Geeks classes. He reaches venue of Geeks classess. Now, he is confused about his sitting place. There are two columns of students sitting in the classes. Each student has been assigned a score on the basis of their score in Geeks class Entrance Contest. Now, he wants to sit in the row which contains students with maximum score. Help him in finding the desired column.

Input : First line of Input contains testcase "T". For each testcase "T", there will be 3 lines of input, first line contains lengths of the columns, and next two lines contains the scores of students sitting in that column.

Output : For each testcase, Output the column in which Sahil should sit.
*/

class SahilLoveGoodScorer {

  public static void main(String[] args) throws IOException {
    //code
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine().trim());

    while (T-- > 0) {
      String inputLine[] = br.readLine().trim().split(" ");
      int n1 = Integer.parseInt(inputLine[0]);
      int n2 = Integer.parseInt(inputLine[1]);

      int arr1[] = new int[n1];
      int arr2[] = new int[n2];

      inputLine = br.readLine().trim().split(" ");
      for (int i = 0; i < n1; i++) arr1[i] = Integer.parseInt(inputLine[i]);

      inputLine = br.readLine().trim().split(" ");
      for (int i = 0; i < n2; i++) arr2[i] = Integer.parseInt(inputLine[i]);

      int sum1 = 0;
      int sum2 = 0;

      for (int i = 0; i < n1; i++) sum1 += arr1[i];

      for (int i = 0; i < n2; i++) sum2 += arr2[i];

      if (sum1 > sum2) System.out.println("C1"); else System.out.println("C2");
    }
  }
}
