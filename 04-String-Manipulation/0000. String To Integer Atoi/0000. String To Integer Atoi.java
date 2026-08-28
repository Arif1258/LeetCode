1class Solution {
2    public int myAtoi(String s) {
3        int i = 0;
4        int n = s.length();
5        while (i < n && s.charAt(i) == ' ') {
6            i++;
7        }
8        int sign = 1;
9
10        if (i < n && s.charAt(i) == '-') {
11            sign = -1;
12            i++;
13        } else if (i < n && s.charAt(i) == '+') {
14            i++;
15        }
16        long result = 0;
17
18        while (i < n && Character.isDigit(s.charAt(i))) {
19            int digit = s.charAt(i) - '0';
20            result = result * 10 + digit;
21            if (sign == 1 && result > Integer.MAX_VALUE) {
22                return Integer.MAX_VALUE;
23            }
24
25            if (sign == -1 && -result < Integer.MIN_VALUE) {
26                return Integer.MIN_VALUE;
27            }
28
29            i++;
30        }
31
32        return (int) (result * sign);
33    }
34}