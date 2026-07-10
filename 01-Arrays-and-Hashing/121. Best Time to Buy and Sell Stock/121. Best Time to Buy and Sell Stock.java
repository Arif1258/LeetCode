1class Solution {
2    public int maxProfit(int[] prices) {
3        int maxProfit = 0;
4        int bestBuy = prices[0];
5
6        for(int i = 1; i<prices.length;i++){
7            if(bestBuy < prices[i]){
8                maxProfit = Math.max(maxProfit, (prices[i]-bestBuy));
9            }
10            bestBuy = Math.min(bestBuy, prices[i]);
11        }
12        return maxProfit;
13    }
14}