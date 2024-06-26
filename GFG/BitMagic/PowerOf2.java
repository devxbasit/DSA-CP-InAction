// //Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class PowerOf2 {

  public static void main(String args[]) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(read.readLine()); //testcases

    while (t-- > 0) {
      //input a number n
      long n = Long.parseLong(read.readLine());

      // if n is less than equal to zero then
      //it can't be a power of 2 so we print No
      if (new PowerCheck().isPowerofTwo(n) == true) System.out.println(
        "YES"
      ); else System.out.println("NO");
    }
  }
}

// } Driver Code Ends

//User function Template for Java

class PowerCheck {

  // Function to check if given number is power of two
  public static boolean isPowerofTwo(long n) {
    // Your code here

    // burte force -  count no. of 1's present

    //

    if (n <= 0) return false;

    return ((n & (n - 1)) == 0) ? true : false;
  }
}
