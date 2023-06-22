// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

// Approach 1 - using DP
class Solution {

  public int maxProfit(int[] prices) {
    int maxPrice = 0, maxProfit = 0;
    int[] maxStockPrice = new int[prices.length];

    for (int i = prices.length - 1; i > -1; i--) {
      maxPrice = Math.max(maxPrice, prices[i]);
    }

    for (int i = 0; i < prices.length - 1; i++) {
      maxProfit = Math.max(maxProfit, maxStockPrice[i + 1] - prices[i]);
    }

    return maxProfit;
  }
}

// Approach 2 - mountain and valley
class Solution {

  public int maxProfit(int[] prices) {
    int minValley = Integer.MAX_VALUE;
    int maxProfit = Integer.MIN_VALUE;

    for (int i = 0; i < prices.length; i++) {
      minValley = Math.min(minValley, prices[i]);
      maxProfit = Math.max(maxProfit, prices[i] - minValley);
    }

    return maxProfit;
  }
}
