1class Solution {
2    public int maxProfit(int[] prices, int fee) {
3
4        int hold = -prices[0];
5        int cash = 0;
6
7        for (int i = 1; i < prices.length; i++) {
8
9            int previousHold = hold;
10            int previousCash = cash;
11
12            // Buy
13            hold = Math.max(previousHold, previousCash - prices[i]);
14
15            // Sell
16            cash = Math.max(previousCash, previousHold + prices[i] - fee);
17        }
18
19        return cash;
20    }
21}