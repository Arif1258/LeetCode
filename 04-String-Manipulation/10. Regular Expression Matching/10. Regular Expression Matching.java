1class Solution {
2    public boolean isMatch(String s, String p) {
3        int m = s.length();
4        int n = p.length();
5        boolean[][] dp = new boolean[m + 1][n + 1];
6        dp[m][n] = true;
7        for (int i = m; i >= 0; i--) {
8            for (int j = n - 1; j >= 0; j--) {
9                boolean firstMatch = (
10                    i < m &&
11                    (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')
12                );
13                if (j + 1 < n && p.charAt(j + 1) == '*') {
14                    dp[i][j] =
15                        dp[i][j + 2] ||
16                        (firstMatch && dp[i + 1][j]);
17
18                } else {
19                    dp[i][j] =
20                        firstMatch &&
21                        dp[i + 1][j + 1];
22                }
23            }
24        }
25        return dp[0][0];
26    }
27}