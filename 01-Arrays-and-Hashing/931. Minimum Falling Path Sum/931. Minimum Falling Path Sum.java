1class Solution {
2    public int minFallingPathSum(int[][] matrix) {
3        int n = matrix.length;
4        int m = matrix[0].length;
5
6        int[][] dp = new int[n][m];
7
8        for (int j = 0; j < m; j++) {
9            dp[0][j] = matrix[0][j];
10        }
11
12        for (int i = 1; i < n; i++) {
13            for (int j = 0; j < m; j++) {
14                int up = dp[i - 1][j];
15                int left = (j > 0) ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
16                int right = (j < m - 1) ? dp[i - 1][j + 1] : Integer.MAX_VALUE;
17
18                dp[i][j] = matrix[i][j] + Math.min(up, Math.min(left, right));
19            }
20        }
21
22        int ans = dp[n - 1][0];
23        for (int j = 1; j < m; j++) {
24            ans = Math.min(ans, dp[n - 1][j]);
25        }
26
27        return ans;
28    }
29}