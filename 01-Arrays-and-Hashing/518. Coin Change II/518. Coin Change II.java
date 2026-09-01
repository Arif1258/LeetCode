1class Solution {
2    public int change(int amount, int[] coins) {
3        int dp[] = new int [amount+1];
4
5        dp[0] = 1;
6
7        for(int coin : coins){
8            for(int i=coin; i<=amount; i++){
9                dp[i] += dp[i-coin];
10            }
11        }
12        return dp[amount];
13    }
14}