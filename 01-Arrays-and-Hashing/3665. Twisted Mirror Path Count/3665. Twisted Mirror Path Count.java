1class Solution {
2    public int uniquePaths(int[][] grid) {
3        final int MOD = 1_000_000_007;
4        int m = grid.length;
5        int n = grid[0].length;
6        int[] dp = new int[n];
7        dp[0] = 1;
8        for (int i = 0; i < m; i++) {
9            int left = 0;
10            for (int j = 0; j < n; j++) {
11                if (grid[i][j] == 1) {
12                    int temp = dp[j];
13                    dp[j] = left;
14                    left = temp;
15                } else {
16                    int total = (dp[j] + left) % MOD;
17                    dp[j] = total;
18                    left = total;
19                }
20            }
21        }
22
23        return dp[n - 1];
24    }
25}