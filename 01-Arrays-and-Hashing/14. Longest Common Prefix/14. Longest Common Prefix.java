1class Solution {
2    public String longestCommonPrefix(String[] strs) {
3        String prefix = strs[0];
4
5        for (int i = 1; i < strs.length; i++) {
6            while (!strs[i].startsWith(prefix)) {
7                prefix = prefix.substring(0, prefix.length() - 1);
8
9                if (prefix.isEmpty()) {
10                    return ;
11                }
12            }
13        }
14
15        return prefix;
16    }
17}