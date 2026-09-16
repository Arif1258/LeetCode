1class Solution {
2    private static final long MOD = 1_000_000_007L;
3
4    public int numberOfSets(int n, int k) {
5        int total = n + k - 1;
6        int choose = 2 * k;
7
8        long[] dp = new long[choose + 1];
9        dp[0] = 1;
10
11        for (int i = 1; i <= total; i++) {
12            for (int j = Math.min(i, choose); j >= 1; j--) {
13                dp[j] = (dp[j] + dp[j - 1]) % MOD;
14            }
15        }
16
17        return (int) dp[choose];
18    }
19}