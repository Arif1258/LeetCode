1class Solution {
2    public int minOperations(String s) {
3        int n = s.length();
4        boolean sorted = true;
5
6        char min = s.charAt(0);
7        char max = s.charAt(0);
8
9        for (int i = 1; i < n; i++) {
10            char c = s.charAt(i);
11
12            min = (char) Math.min(min, c);
13            max = (char) Math.max(max, c);
14
15            if (c < s.charAt(i - 1)) {
16                sorted = false;
17            }
18        }
19
20        if (sorted) {
21            return 0;
22        }
23
24        if (n == 2) {
25            return -1;
26        }
27
28        if (s.charAt(0) == min || s.charAt(n - 1) == max) {
29            return 1;
30        }
31
32        for (int i = 1; i < n - 1; i++) {
33            char c = s.charAt(i);
34
35            if (c == min || c == max) {
36                return 2;
37            }
38        }
39
40        return 3;
41    }
42}