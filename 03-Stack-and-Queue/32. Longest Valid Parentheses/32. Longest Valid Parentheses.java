1class Solution {
2    public int longestValidParentheses(String s) {
3        int left = 0;
4        int right = 0;
5        int maxLen = 0;
6        for (int i = 0; i < s.length(); i++) {
7            if (s.charAt(i) == '(') {
8                left++;
9            } else {
10                right++;
11            }
12
13            if (left == right) {
14                maxLen = Math.max(maxLen, 2 * right);
15            } else if (right > left) {
16                left = 0;
17                right = 0;
18            }
19        }
20        left = 0;
21        right = 0;
22
23        for (int i = s.length() - 1; i >= 0; i--) {
24            if (s.charAt(i) == '(') {
25                left++;
26            } else {
27                right++;
28            }
29
30            if (left == right) {
31                maxLen = Math.max(maxLen, 2 * left);
32            } else if (left > right) {
33                left = 0;
34                right = 0;
35            }
36        }
37
38        return maxLen;
39    }
40}