1class Solution {
2    public int climbStairs(int n, int[] costs) {
3        int[] dp = new int[n + 1];
4
5        dp[0] = 0;
6
7        for (int i = 1; i <= n; i++) {
8            int cost = costs[i - 1];
9            dp[i] = Integer.MAX_VALUE;
10            dp[i] = Math.min(dp[i], dp[i - 1] + cost + 1);
11            if (i >= 2) {
12                dp[i] = Math.min(dp[i], dp[i - 2] + cost + 4);
13            }
14            if (i >= 3) {
15                dp[i] = Math.min(dp[i], dp[i - 3] + cost + 9);
16            }
17        }
18
19        return dp[n];
20    }
21}
22