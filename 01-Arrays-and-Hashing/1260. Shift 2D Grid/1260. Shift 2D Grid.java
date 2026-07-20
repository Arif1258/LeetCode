1class Solution {
2    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
3        int m = grid.length;
4        int n = grid[0].length;
5        int total = m * n;
6        k %= total;
7        int[][] result = new int[m][n];
8        for (int i = 0; i < m; i++) {
9            for (int j = 0; j < n; j++) {
10                int oldIndex = i * n + j;
11                int newIndex = (oldIndex + k) % total;
12
13                int newRow = newIndex / n;
14                int newCol = newIndex % n;
15
16                result[newRow][newCol] = grid[i][j];
17            }
18        }
19        List<List<Integer>> ans = new ArrayList<>();
20        for (int i = 0; i < m; i++) {
21            List<Integer> row = new ArrayList<>();
22            for (int j = 0; j < n; j++) {
23                row.add(result[i][j]);
24            }
25            ans.add(row);
26        }
27        return ans;
28    }
29}