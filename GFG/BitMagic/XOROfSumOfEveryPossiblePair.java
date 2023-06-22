import java.io.*;

public class XOROfSumOfEveryPossiblePair {

  /*
    XOR of Sum of every possible pair of an array

    Input: arr = {1, 5, 6}
    Output: 4
    B[2*2] = { 1+1, 1+5, 1+6, 5+1, 5+5, 5+6, 6+1, 6+5, 6+6}
    B[4] = { 2, 6, 7, 6, 10, 11, 7, 11, 12}
    So, 2 ^ 6 ^ 7 ^ 6 ^ 10 ^ 11 ^ 7 ^ 6 ^ 11 ^ 12 = 4
*/
  public static void main(String[] args) {
    int arr[] = { 1, 5, 6 };

    // A ^ A = 0

    // A ^ 0 = A; identity
    // A ^ 1 = 0

    int res = 0;

    for (int i = 0; i < arr.length; i++) {
      res = res ^ (arr[i] + arr[i]);
    }

    System.out.println(res);
  }
}
