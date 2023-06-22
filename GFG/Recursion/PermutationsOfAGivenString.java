//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class PermutationsOfAGivenString {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    sc.nextLine();
    while (T-- > 0) {
      Permutation obj = new Permutation();

      String S = sc.nextLine();

      ArrayList<String> arr = obj.permutation(S);
      for (String s : arr) {
        System.out.print(s + " ");
      }
      System.out.println();
    }
  }
}

// } Driver Code Ends

//User function Template for Java

class Permutation {

  ArrayList<String> al = new ArrayList<>();

  public String swap(String s, int i, int j) {
    char ch[] = s.toCharArray();

    char temp = ch[i];

    ch[i] = ch[j];
    ch[j] = temp;

    return String.valueOf(ch);
  }

  public void premute(String s, int left, int right) {
    if (left == right) {
      al.add(s);
      return;
    }

    for (int i = left; i <= right; i++) {
      s = swap(s, left, i);

      premute(s, left + 1, right);

      s = swap(s, left, i);
    }
  }

  public ArrayList<String> permutation(String S) {
    //Your code here
    al.clear();

    premute(S, 0, S.length() - 1);

    // can be done using sorted treeset
    Collections.sort(al);
    return al;
  }
}
