1class Solution {
2    public int maxProfit(int[] prices) {
3        int hold = -prices[0];
4        int sold = 0;
5        int rest = 0;
6
7        for (int i = 1; i < prices.length; i++) {
8            int prevHold = hold;
9            int prevSold = sold;
10            int prevRest = rest;
11
12            hold = Math.max(prevHold, prevRest - prices[i]);
13            sold = prevHold + prices[i];
14            rest = Math.max(prevRest, prevSold);
15        }
16
17        return Math.max(sold, rest);
18    }
19}