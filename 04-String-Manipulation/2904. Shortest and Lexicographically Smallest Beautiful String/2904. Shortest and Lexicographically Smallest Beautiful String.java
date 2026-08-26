1class Solution {
2    public String shortestBeautifulSubstring(String s, int k) {
3        String ans = ;
4        for (int i = 0; i < s.length(); i++) {
5            int ones = 0;
6            for (int j = i; j < s.length(); j++) {
7                if (s.charAt(j) == '1') {
8                    ones++;
9                }
10                if (ones == k) {
11                    String cur = s.substring(i, j + 1);
12                    if (ans.isEmpty()
13                            || cur.length() < ans.length()
14                            || (cur.length() == ans.length()
15                                && cur.compareTo(ans) < 0)) {
16                        ans = cur;
17                    }
18                    break;
19                }
20            }
21        }
22
23        return ans;
24    }
25}