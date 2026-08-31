1class Solution {
2    public int minPathSum(int[][] grid) {
3
4        int m = grid.length;
5        int n = grid[0].length;
6
7        int[][] dp = new int[m][n];
8
9        dp[0][0] = grid[0][0];
10
11        // First column
12        for (int i = 1; i < m; i++) {
13            dp[i][0] = dp[i - 1][0] + grid[i][0];
14        }
15
16        // First row
17        for (int j = 1; j < n; j++) {
18            dp[0][j] = dp[0][j - 1] + grid[0][j];
19        }
20
21        // Remaining cells
22        for (int i = 1; i < m; i++) {
23            for (int j = 1; j < n; j++) {
24
25                dp[i][j] = grid[i][j]
26                         + Math.min(dp[i - 1][j], dp[i][j - 1]);
27            }
28        }
29
30        return dp[m - 1][n - 1];
31    }
32}