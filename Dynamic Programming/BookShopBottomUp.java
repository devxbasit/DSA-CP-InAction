import java.io.*;
import java.util.*;

// bottom up approach
class BookShopBottomUp {

    public static int maxPages(int price[], int pages[], int n, int amount) {
        
        if (n <= 0 || amount <= 0) return 0;
               
        int dp[][] = new int[n + 1][amount + 1]; 

        for (int i = 1; i < dp.length; i++) {

            for (int money = 1; money < dp[0].length; money++) {

                if (price[i - 1] > money) {

                    dp[i][money] = dp[i - 1][money];
                    continue;
                }

                dp[i][money] = Math.max(pages[i - 1] + dp[i - 1][money - price[i - 1]], dp[i - 1][money]);

            }
        }

        return dp[n][amount];

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

        System.out.println(maxPages(price, pages, n, amount));

    }
}