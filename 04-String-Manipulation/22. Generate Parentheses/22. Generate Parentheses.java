1class Solution {
2    public List<String> generateParenthesis(int n) {
3        List<String> result = new ArrayList<>();
4        backtrack(result, new StringBuilder(), 0, 0, n);
5        return result;
6    }
7    private void backtrack(List<String> result, StringBuilder sb,
8                            int open, int close, int n) {
9
10        if (sb.length() == 2 * n) {
11            result.add(sb.toString());
12            return;
13        }
14        if (open < n) {
15            sb.append('(');
16            backtrack(result, sb, open + 1, close, n);
17            sb.deleteCharAt(sb.length() - 1);
18        }
19        if (close < open) {
20            sb.append(')');
21            backtrack(result, sb, open, close + 1, n);
22            sb.deleteCharAt(sb.length() - 1);
23        }
24    }
25}