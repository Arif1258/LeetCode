1class Solution {
2    public int scoreOfParentheses(String s) {
3        Stack<Integer> stack = new Stack<>();
4        stack.push(0);
5
6        for (char ch : s.toCharArray()) {
7            if (ch == '(') {
8                stack.push(0);
9            } else {
10                int inside = stack.pop();
11                int score = (inside == 0) ? 1 : 2 * inside;
12
13                stack.push(stack.pop() + score);
14            }
15        }
16
17        return stack.pop();
18    }
19}