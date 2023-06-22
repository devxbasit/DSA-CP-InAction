// { Driver Code Starts
import java.io.*;
import java.util.*;

class WinnerOfAnElection {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while (t-- > 0) {
      int n = sc.nextInt();
      String arr[] = new String[n];

      for (int i = 0; i < n; i++) arr[i] = sc.next();

      Sol obj = new Sol();
      String result[] = obj.winner(arr, n);
      System.out.println(result[0] + " " + result[1]);
    }
  }
}

// } Driver Code Ends

//User function Template for Java

/*
class pair 
{
    String first;
    int second;
    pair(String first , int second)
        {
            this.first = first;
            this.second = second;
        }
}
*/
class Sol {

  public static String[] winner(String str[], int n) {
    // add your code
    HashMap<String, Integer> votes = new HashMap<>();
    int count;

    for (int i = 0; i < n; i++) {
      count = 1;

      if (votes.containsKey(str[i])) count = votes.get(str[i]) + 1;

      votes.put(str[i], count);
    }

    int maxVotes = 0;
    String winner = "";

    for (Map.Entry<String, Integer> entry : votes.entrySet()) {
      String candidate = entry.getKey();
      int votesCount = entry.getValue();

      if (votesCount > maxVotes) {
        maxVotes = votesCount;
        winner = candidate;
      }

      if (votesCount == maxVotes) if (winner.compareTo(candidate) > 0) winner =
        candidate;
    }

    return new String[] { winner, Integer.toString(maxVotes) };
  }
}
