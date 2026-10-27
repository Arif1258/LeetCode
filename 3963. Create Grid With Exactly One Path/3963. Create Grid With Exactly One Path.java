1class Solution {
2    public String[] createGrid(int m, int n) {
3        String[] grid = new String[m];
4
5        for (int i = 0; i < m; i++) {
6            char[] row = new char[n];
7            java.util.Arrays.fill(row, '#');
8
9            if (i == 0) {
10                java.util.Arrays.fill(row, '.');
11            } else {
12                row[n - 1] = '.';
13            }
14
15            grid[i] = new String(row);
16        }
17
18        return grid;
19    }
20}