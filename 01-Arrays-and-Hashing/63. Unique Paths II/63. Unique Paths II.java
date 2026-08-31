1class Solution {
2    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
3        int m = obstacleGrid.length;
4        int n = obstacleGrid[0].length;
5        int dp[][] = new int [m][n];
6
7        if(obstacleGrid[0][0] == 1) return 0;
8        dp[0][0] = 1;
9
10        for (int i = 1; i < m; i++) {
11            if (obstacleGrid[i][0] == 0) {
12                dp[i][0] = dp[i - 1][0];
13            }
14        }
15
16        // First row
17        for (int j = 1; j < n; j++) {
18            if (obstacleGrid[0][j] == 0) {
19                dp[0][j] = dp[0][j - 1];
20            }
21        }
22
23
24
25        for (int i = 1; i < m; i++) {
26            for (int j = 1; j < n; j++) {
27
28                if (obstacleGrid[i][j] == 1) {
29                    dp[i][j] = 0;
30                } else {
31                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
32                }
33            }
34        }
35
36        return dp[m - 1][n - 1];
37    }
38}