import java.io.*;
import java.util.*;

// Top Down approach

// TIME LIMIT EXCEEDED
class BookShopTopDown {

    public static int maxPages(int price[], int pages[], int dp[][], int n, int amount) {
        
        if (n <= 0 || amount <= 0) return 0;

        if (dp[n][amount] != -1) {

            return dp[n][amount];

        }

        if (price[n - 1] > amount) {

            return dp[n][amount] = maxPages(price, pages, dp, n - 1, amount);

        }

        return dp[n][amount] = Math.max(pages[n - 1] + maxPages(price, pages, dp, n - 1, amount - price[n - 1 ]), maxPages(price, pages, dp, n - 1, amount)); 

    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String l1[] = br.readLine().trim().split(" ");
        String l2[] = br.readLine().trim().split(" ");
        String l3[] = br.readLine().trim().split(" ");

        int n = Integer.parseInt(l1[0]);
        int amount = Integer.parseInt(l1[1]);

        int price[] = new int[n];
        int pages[] = new int[n];


        for (int i = 0; i < n; i++) {

            price[i] = Integer.parseInt(l2[i]);
            pages[i] = Integer.parseInt(l3[i]);

        }
            
        // same as 01 knapsack
        
        int dp[][] = new int[n + 1][amount + 1]; 

        for (int i = 0; i < dp.length; i++) {

            for (int j = 0; j < dp[0].length; j++) {

                dp[i][j] = -1;

            }
        }

        System.out.println(maxPages(price, pages, dp, n, amount));

    }
}