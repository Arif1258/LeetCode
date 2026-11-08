1class Solution {
2    public int countServers(int[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5        int[] row = new int[m];
6        int[] col = new int[n];
7        for (int i = 0; i < m; i++) {
8            for (int j = 0; j < n; j++) {
9                if (grid[i][j] == 1) {
10                    row[i]++;
11                    col[j]++;
12                }
13            }
14        }
15
16        int count = 0;
17        for (int i = 0; i < m; i++) {
18            for (int j = 0; j < n; j++) {
19                if (grid[i][j] == 1 &&
20                    (row[i] > 1 || col[j] > 1)) {
21                    count++;
22                }
23            }
24        }
25
26        return count;
27    }
28}
29