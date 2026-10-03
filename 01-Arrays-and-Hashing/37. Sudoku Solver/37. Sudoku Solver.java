1class Solution {
2
3    public void solveSudoku(char[][] board) {
4        solve(board);
5    }
6
7    private boolean solve(char[][] board) {
8
9        for (int row = 0; row < 9; row++) {
10            for (int col = 0; col < 9; col++) {
11
12                if (board[row][col] == '.') {
13                    for (char num = '1'; num <= '9'; num++) {
14                        if (isValid(board, row, col, num)) {
15                            board[row][col] = num;
16
17                            if (solve(board)) {
18                                return true;
19                            }
20                            board[row][col] = '.';
21                        }
22                    }
23                    return false;
24                }
25            }
26        }
27        return true;
28    }
29
30    private boolean isValid(char[][] board, int row, int col, char num) {
31        for (int j = 0; j < 9; j++) {
32            if (board[row][j] == num) {
33                return false;
34            }
35        }
36        for (int i = 0; i < 9; i++) {
37            if (board[i][col] == num) {
38                return false;
39            }
40        }
41        int startRow = (row / 3) * 3;
42        int startCol = (col / 3) * 3;
43
44        for (int i = startRow; i < startRow + 3; i++) {
45            for (int j = startCol; j < startCol + 3; j++) {
46                if (board[i][j] == num) {
47                    return false;
48                }
49            }
50        }
51
52        return true;
53    }
54}