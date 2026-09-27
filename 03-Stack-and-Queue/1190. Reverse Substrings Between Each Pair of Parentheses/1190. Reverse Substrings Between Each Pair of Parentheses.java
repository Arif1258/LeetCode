1class Solution {
2    public String reverseParentheses(String s) {
3        Stack<String> stack = new Stack<>();
4        StringBuilder current = new StringBuilder();
5
6        for (char ch : s.toCharArray()) {
7
8            if (ch == '(') {
9                stack.push(current.toString());
10                current.setLength(0);
11
12            } else if (ch == ')') {
13                current.reverse();
14                current.insert(0, stack.pop());
15            } else {
16                current.append(ch);
17            }
18        }
19
20        return current.toString();
21    }
22}