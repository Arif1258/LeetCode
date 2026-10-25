1class Solution {
2    public int closedIsland(int[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5        int count = 0;
6        for (int i = 0; i < m; i++) {
7            dfs(grid, i, 0);
8            dfs(grid, i, n - 1);
9        }
10
11        for (int j = 0; j < n; j++) {
12            dfs(grid, 0, j);
13            dfs(grid, m - 1, j);
14        }
15        for (int i = 1; i < m - 1; i++) {
16            for (int j = 1; j < n - 1; j++) {
17                if (grid[i][j] == 0) {
18                    dfs(grid, i, j);
19                    count++;
20                }
21            }
22        }
23
24        return count;
25    }
26
27    private void dfs(int[][] grid, int r, int c) {
28        int m = grid.length;
29        int n = grid[0].length;
30
31        if (r < 0 || c < 0 || r >= m || c >= n ||
32            grid[r][c] == 1) {
33            return;
34        }
35        grid[r][c] = 1;
36
37        dfs(grid, r + 1, c);
38        dfs(grid, r - 1, c);
39        dfs(grid, r, c + 1);
40        dfs(grid, r, c - 1);
41    }
42}
43