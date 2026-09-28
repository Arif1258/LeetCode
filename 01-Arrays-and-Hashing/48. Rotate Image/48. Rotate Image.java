1class Solution {
2    public void rotate(int[][] matrix) {
3        int n = matrix.length;
4
5        for (int i = 0; i < n; i++) {
6            for (int j = i + 1; j < n; j++) {
7                int temp = matrix[i][j];
8                matrix[i][j] = matrix[j][i];
9                matrix[j][i] = temp;
10            }
11        }
12        for (int i = 0; i < n; i++) {
13            int left = 0;
14            int right = n - 1;
15
16            while (left < right) {
17                int temp = matrix[i][left];
18                matrix[i][left] = matrix[i][right];
19                matrix[i][right] = temp;
20
21                left++;
22                right--;
23            }
24        }
25    }
26}