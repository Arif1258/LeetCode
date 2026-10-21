1
2class Solution {
3    int m, n;
4    public void dfs(int r, int c, int[][] grid) {
5        if (r < 0 || c < 0 || r >= m || c >= n ||
6            grid[r][c] == 0) {
7            return;
8        }
9        grid[r][c] = 0;
10        dfs(r + 1, c, grid);
11        dfs(r - 1, c, grid);
12        dfs(r, c + 1, grid);
13        dfs(r, c - 1, grid);
14    }
15
16    public int numEnclaves(int[][] grid) {
17        m = grid.length;
18        n = grid[0].length;
19        for (int i = 0; i < m; i++) {
20            if (grid[i][0] == 1) {
21                dfs(i, 0, grid);
22            }
23
24            if (grid[i][n - 1] == 1) {
25                dfs(i, n - 1, grid);
26            }
27        }
28
29        for (int j = 0; j < n; j++) {
30            if (grid[0][j] == 1) {
31                dfs(0, j, grid);
32            }
33
34            if (grid[m - 1][j] == 1) {
35                dfs(m - 1, j, grid);
36            }
37        }
38        int count = 0;
39        for (int i = 0; i < m; i++) {
40            for (int j = 0; j < n; j++) {
41                if (grid[i][j] == 1) {
42                    count++;
43                }
44            }
45        }
46
47        return count;
48    }
49}
50