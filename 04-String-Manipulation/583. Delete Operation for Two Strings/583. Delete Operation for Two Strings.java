1class Solution {
2    public int minDistance(String word1, String word2) {
3        int m = word1.length();
4        int n = word2.length();
5
6        int[][] dp = new int[m + 1][n + 1];
7
8        for (int i = 0; i <= m; i++) {
9            dp[i][0] = i;
10        }
11
12        for (int j = 0; j <= n; j++) {
13            dp[0][j] = j;
14        }
15
16        for (int i = 1; i <= m; i++) {
17            for (int j = 1; j <= n; j++) {
18                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
19                    dp[i][j] = dp[i - 1][j - 1];
20                } else {
21                    int del1 = dp[i - 1][j] + 1;
22                    int del2 = dp[i][j - 1] + 1;
23
24                    dp[i][j] = Math.min(del1, del2);
25                }
26            }
27        }
28
29        return dp[m][n];
30    }
31}