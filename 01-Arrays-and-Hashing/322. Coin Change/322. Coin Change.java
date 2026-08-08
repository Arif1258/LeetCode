1class Solution {
2    public int coinChange(int[] coins, int amount) {
3        int n = coins.length;
4        int[][] dp = new int[n + 1][amount + 1];
5        for (int i = 0; i <= n; i++) {
6            dp[i][0] = 0;
7        }
8        for (int j = 1; j <= amount; j++) {
9            dp[0][j] = amount + 1;
10        }
11        for (int i = 1; i <= n; i++) {
12            for (int j = 1; j <= amount; j++) {
13                dp[i][j] = dp[i - 1][j];
14                if (coins[i - 1] <= j) {
15                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j - coins[i - 1]]
16                    );
17                }
18            }
19        }
20        return dp[n][amount] > amount ? -1 : dp[n][amount];
21    }
22}