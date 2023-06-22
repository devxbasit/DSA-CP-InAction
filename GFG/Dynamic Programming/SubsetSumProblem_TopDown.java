// interviewbit

public class Solution {

  public int solve(int[] A, int B) {
    if (B == 0) {
      return 1;
    }

    boolean dp[][] = new boolean[A.length + 1][B + 1];

    for (int j = 0; j < dp[0].length; j++) {
      dp[0][j] = false;
    }

    for (int i = 0; i < dp.length; i++) {
      dp[i][0] = true;
    }

    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        if (A[i - 1] <= j) {
          dp[i][j] = (dp[i - 1][j - A[i - 1]] || dp[i - 1][j]);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    return (dp[dp.length - 1][dp[0].length - 1] == true) ? 1 : 0;
  }
}
