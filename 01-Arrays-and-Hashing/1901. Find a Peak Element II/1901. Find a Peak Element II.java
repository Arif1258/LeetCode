1class Solution {
2    public int[] findPeakGrid(int[][] mat) {
3        int m = mat.length;
4        int n = mat[0].length;
5
6        int low = 0, high = n - 1;
7
8        while (low <= high) {
9            int mid = low + (high - low) / 2;
10
11            int maxRow = 0;
12
13            for (int i = 1; i < m; i++) {
14                if (mat[i][mid] > mat[maxRow][mid]) {
15                    maxRow = i;
16                }
17            }
18
19            int left = mid > 0 ? mat[maxRow][mid - 1] : -1;
20            int right = mid < n - 1 ? mat[maxRow][mid + 1] : -1;
21
22            if (mat[maxRow][mid] > left &&
23                mat[maxRow][mid] > right) {
24                return new int[]{maxRow, mid};
25            }
26
27            if (right > mat[maxRow][mid]) {
28                low = mid + 1;
29            } else {
30                high = mid - 1;
31            }
32        }
33
34        return new int[]{-1, -1};
35    }
36}