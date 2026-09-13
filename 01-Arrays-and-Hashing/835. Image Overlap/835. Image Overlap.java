1class Solution {
2    public int largestOverlap(int[][] img1, int[][] img2) {
3        int n = img1.length;
4
5        int[][] shifts = new int[2 * n - 1][2 * n - 1];
6
7        for (int r1 = 0; r1 < n; r1++) {
8            for (int c1 = 0; c1 < n; c1++) {
9
10                if (img1[r1][c1] == 0) continue;
11
12                for (int r2 = 0; r2 < n; r2++) {
13                    for (int c2 = 0; c2 < n; c2++) {
14
15                        if (img2[r2][c2] == 0) continue;
16
17                        int dr = r1 - r2;
18                        int dc = c1 - c2;
19
20                        shifts[dr + n - 1][dc + n - 1]++;
21                    }
22                }
23            }
24        }
25
26        int ans = 0;
27
28        for (int i = 0; i < 2 * n - 1; i++) {
29            for (int j = 0; j < 2 * n - 1; j++) {
30                ans = Math.max(ans, shifts[i][j]);
31            }
32        }
33
34        return ans;
35    }
36}