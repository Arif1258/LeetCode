1class Solution {
2    public int longestPalindromeSubseq(String s) {
3        String reversed = new StringBuilder(s).reverse().toString();
4
5        int n = s.length();
6        int[][] dp = new int[n + 1][n + 1];
7
8        for (int i = 1; i <= n; i++) {
9            for (int j = 1; j <= n; j++) {
10
11                if (s.charAt(i - 1) == reversed.charAt(j - 1)) {
12                    dp[i][j] = dp[i - 1][j - 1] + 1;
13                } else {
14                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
15                }
16            }
17        }
18
19        return dp[n][n];
20    }
21}