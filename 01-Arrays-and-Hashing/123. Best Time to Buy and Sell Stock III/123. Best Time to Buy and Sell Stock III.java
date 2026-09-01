1class Solution {
2    public int maxProfit(int[] prices) {
3
4        int buy1 = -prices[0];
5        int sell1 = 0;
6
7        int buy2 = -prices[0];
8        int sell2 = 0;
9
10        for (int i = 1; i < prices.length; i++) {
11
12
13            buy1 = Math.max(buy1, -prices[i]);
14            sell1 = Math.max(sell1, buy1 + prices[i]);
15
16
17            buy2 = Math.max(buy2, sell1 - prices[i]);
18            sell2 = Math.max(sell2, buy2 + prices[i]);
19        }
20
21        return sell2;
22    }
23}