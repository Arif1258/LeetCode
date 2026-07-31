1class Solution {
2    public String reverseWords(String s) {
3        StringBuilder ans = new StringBuilder();
4        int start = 0;
5        for (int i = 0; i <= s.length(); i++) {
6            if (i == s.length() || s.charAt(i) == ' ') {
7                for (int j = i - 1; j >= start; j--) {
8                    ans.append(s.charAt(j));
9                }
10                if (i != s.length()) {
11                    ans.append(' ');
12                }
13                start = i + 1;
14            }
15        }
16        return ans.toString();
17    }
18}