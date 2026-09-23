1class Solution {
2    public int countSquares(int[][] matrix) {
3        int m = matrix.length;
4        int n = matrix[0].length;
5
6        int[][] dp = new int[m][n];
7        int count = 0;
8
9        for (int i = 0; i < m; i++) {
10            for (int j = 0; j < n; j++) {
11
12                if (matrix[i][j] == 1) {
13
14                    if (i == 0 || j == 0) {
15                        dp[i][j] = 1;
16                    } else {
17                        dp[i][j] = 1 + Math.min(
18                            dp[i - 1][j],
19                            Math.min(dp[i][j - 1], dp[i - 1][j - 1])
20                        );
21                    }
22
23                    count += dp[i][j];
24                }
25            }
26        }
27        return count;
28    }
29}