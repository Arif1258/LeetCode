1class Solution {
2    public int fib(int n) {
3        if (n <= 1) {
4            return n;
5        }
6
7        int[] dp = new int[n + 1];
8
9        dp[0] = 0;
10        dp[1] = 1;
11
12        for (int i = 2; i <= n; i++) {
13            dp[i] = dp[i - 1] + dp[i - 2];
14        }
15
16        return dp[n];
17    }
18}