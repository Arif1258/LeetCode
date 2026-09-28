1class Solution {
2    public int maxDepth(String s) {
3        int depth = 0;
4        int maxDepth = 0;
5        for (char ch : s.toCharArray()) {
6            if (ch == '(') {
7                depth++;
8                maxDepth = Math.max(maxDepth, depth);
9            } else if (ch == ')') {
10                depth--;
11            }
12        }
13
14        return maxDepth;
15    }
16}