1class Solution {
2    public int minChanges(String s) {
3        int changes = 0;
4
5        for (int i = 0; i < s.length(); i += 2) {
6            if (s.charAt(i) != s.charAt(i + 1)) {
7                changes++;
8            }
9        }
10
11        return changes;
12    }
13}
14