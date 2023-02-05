// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
class Solution {

    public int maxProfit(int[] prices) {

        int profit = 0;

        int i = 0;

        while (i < prices.length - 1) {

            // find valley - go down as much as you can
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {

                i++;

            }

            int valley = prices[i];

            // find peak - go up
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;

            int peak = prices[i];

            profit += peak - valley;

        }

        return profit;
    }
}