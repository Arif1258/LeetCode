1class Solution {
2    public String digitSum(String s, int k) {
3        while (s.length() > k) {
4            StringBuilder sb = new StringBuilder();
5
6            for (int i = 0; i < s.length(); i += k) {
7                int sum = 0;
8
9                for (int j = i; j < Math.min(i + k, s.length()); j++) {
10                    sum += s.charAt(j) - '0';
11                }
12
13                sb.append(sum);
14            }
15            s = sb.toString();
16        }
17
18        return s;
19    }
20}