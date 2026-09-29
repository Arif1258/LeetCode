1class Solution {
2    int m, n;
3    Boolean[][][] dp;
4
5    public boolean hasValidPath(char[][] grid) {
6        m = grid.length;
7        n = grid[0].length;
8
9        if ((m + n - 1) % 2 != 0) return false;
10        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') return false;
11
12        dp = new Boolean[m][n][m + n];
13
14        return dfs(grid, 0, 0, 0);
15    }
16
17    private boolean dfs(char[][] grid, int r, int c, int balance) {
18        if (grid[r][c] == '(') balance++;
19        else balance--;
20
21        if (balance < 0) return false;
22
23        int remaining = (m - r - 1) + (n - c - 1);
24        if (balance > remaining) return false;
25
26        if (r == m - 1 && c == n - 1) {
27            return balance == 0;
28        }
29
30        if (dp[r][c][balance] != null) {
31            return dp[r][c][balance];
32        }
33
34        boolean down = false;
35        boolean right = false;
36
37        if (r + 1 < m) {
38            down = dfs(grid, r + 1, c, balance);
39        }
40
41        if (c + 1 < n) {
42            right = dfs(grid, r, c + 1, balance);
43        }
44
45        return dp[r][c][balance] = down || right;
46    }
47}