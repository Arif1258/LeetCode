1
2class Solution {
3    private int rows, cols;
4    private int[][] grid;
5    private boolean[][] visited;
6    private int k;
7
8    public int countIslands(int[][] grid, int k) {
9        this.grid = grid;
10        this.k = k;
11        rows = grid.length;
12        cols = grid[0].length;
13        visited = new boolean[rows][cols];
14
15        int count = 0;
16
17        for (int i = 0; i < rows; i++) {
18            for (int j = 0; j < cols; j++) {
19                if (grid[i][j] != 0 && !visited[i][j]) {
20                    long sum = dfs(i, j);
21
22                    if (sum % k == 0) {
23                        count++;
24                    }
25                }
26            }
27        }
28
29        return count;
30    }
31
32    private long dfs(int r, int c) {
33        if (r < 0 || r >= rows || c < 0 || c >= cols
34                || grid[r][c] == 0 || visited[r][c]) {
35            return 0;
36        }
37
38        visited[r][c] = true;
39
40        long sum = grid[r][c];
41
42        sum += dfs(r - 1, c);
43        sum += dfs(r + 1, c);
44        sum += dfs(r, c - 1);
45        sum += dfs(r, c + 1);
46
47        return sum;
48    }
49}
50