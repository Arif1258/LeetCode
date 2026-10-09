1class Solution {
2    public int minInsertions(String s) {
3        int insertions = 0;
4        int open = 0;
5        for (int i = 0; i < s.length(); i++) {
6            char ch = s.charAt(i);
7            if (ch == '(') {
8                open++;
9            } else {
10                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
11                    i++;
12                } else {
13                    insertions++;
14                }
15
16                if (open > 0) {
17                    open--;
18                } else {
19                    insertions++;
20                }
21            }
22        }
23        return insertions + 2 * open;
24    }
25}
26