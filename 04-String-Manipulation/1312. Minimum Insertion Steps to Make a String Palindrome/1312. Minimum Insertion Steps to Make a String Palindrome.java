1class Solution {
2    public int minInsertions(String s) {
3        String rev = new StringBuilder(s).reverse().toString();
4        int n = s.length();
5        int[][] dp = new int[n + 1][n + 1];
6        for (int i = 1; i <= n; i++) {
7            for (int j = 1; j <= n; j++) {
8
9                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
10                    dp[i][j] = 1 + dp[i - 1][j - 1];
11                } else {
12                    dp[i][j] = Math.max(
13                        dp[i - 1][j],
14                        dp[i][j - 1]
15                    );
16                }
17            }
18        }
19        return n - dp[n][n];
20    }
21}