1class Solution {
2    public void setZeroes(int[][] matrix) {
3        int m = matrix.length;
4        int n = matrix[0].length;
5
6        boolean firstRow = false;
7        boolean firstCol = false;
8
9        // Check first row
10        for (int j = 0; j < n; j++) {
11            if (matrix[0][j] == 0) {
12                firstRow = true;
13            }
14        }
15
16        // Check first column
17        for (int i = 0; i < m; i++) {
18            if (matrix[i][0] == 0) {
19                firstCol = true;
20            }
21        }
22
23        // Mark rows and columns
24        for (int i = 1; i < m; i++) {
25            for (int j = 1; j < n; j++) {
26                if (matrix[i][j] == 0) {
27                    matrix[i][0] = 0;
28                    matrix[0][j] = 0;
29                }
30            }
31        }
32
33        // Make marked rows zero
34        for (int i = 1; i < m; i++) {
35            if (matrix[i][0] == 0) {
36                for (int j = 1; j < n; j++) {
37                    matrix[i][j] = 0;
38                }
39            }
40        }
41
42        // Make marked columns zero
43        for (int j = 1; j < n; j++) {
44            if (matrix[0][j] == 0) {
45                for (int i = 1; i < m; i++) {
46                    matrix[i][j] = 0;
47                }
48            }
49        }
50
51        // Handle first row
52        if (firstRow) {
53            for (int j = 0; j < n; j++) {
54                matrix[0][j] = 0;
55            }
56        }
57
58        // Handle first column
59        if (firstCol) {
60            for (int i = 0; i < m; i++) {
61                matrix[i][0] = 0;
62            }
63        }
64    }
65}