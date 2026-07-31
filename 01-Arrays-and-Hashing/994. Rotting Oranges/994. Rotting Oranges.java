1import java.util.*;
2
3class Solution {
4    public int orangesRotting(int[][] grid) {
5        int n = grid.length;
6        int m = grid[0].length;
7        int ans = 0;
8
9        boolean[][] vis = new boolean[n][m];
10
11        Queue<Pair<Pair<Integer, Integer>, Integer>> q = new LinkedList<>();
12
13        // Add all rotten oranges to the queue
14        for (int i = 0; i < n; i++) {
15            for (int j = 0; j < m; j++) {
16                if (grid[i][j] == 2) {
17                    q.offer(new Pair<>(new Pair<>(i, j), 0));
18                    vis[i][j] = true;
19                }
20            }
21        }
22
23        while (!q.isEmpty()) {
24
25            Pair<Pair<Integer, Integer>, Integer> curr = q.poll();
26
27            int i = curr.getKey().getKey();
28            int j = curr.getKey().getValue();
29            int time = curr.getValue();
30
31            ans = Math.max(ans, time);
32
33            // Up
34            if (i - 1 >= 0 && grid[i - 1][j] == 1 && !vis[i - 1][j]) {
35                vis[i - 1][j] = true;
36                q.offer(new Pair<>(new Pair<>(i - 1, j), time + 1));
37            }
38
39            // Down
40            if (i + 1 < n && grid[i + 1][j] == 1 && !vis[i + 1][j]) {
41                vis[i + 1][j] = true;
42                q.offer(new Pair<>(new Pair<>(i + 1, j), time + 1));
43            }
44
45            // Left
46            if (j - 1 >= 0 && grid[i][j - 1] == 1 && !vis[i][j - 1]) {
47                vis[i][j - 1] = true;
48                q.offer(new Pair<>(new Pair<>(i, j - 1), time + 1));
49            }
50
51            // Right
52            if (j + 1 < m && grid[i][j + 1] == 1 && !vis[i][j + 1]) {
53                vis[i][j + 1] = true;
54                q.offer(new Pair<>(new Pair<>(i, j + 1), time + 1));
55            }
56        }
57
58        // Check if any fresh orange remains
59        for (int i = 0; i < n; i++) {
60            for (int j = 0; j < m; j++) {
61                if (grid[i][j] == 1 && !vis[i][j]) {
62                    return -1;
63                }
64            }
65        }
66
67        return ans;
68    }
69}