1class Solution {
2    public int divide(int dividend, int divisor) {
3
4        // Overflow case
5        if (dividend == Integer.MIN_VALUE && divisor == -1) {
6            return Integer.MAX_VALUE;
7        }
8
9        boolean negative = (dividend < 0) ^ (divisor < 0);
10
11        // Work with negative numbers to avoid overflow
12        int a = dividend;
13        int b = divisor;
14
15        if (a > 0) {
16            a = -a;
17        }
18
19        if (b > 0) {
20            b = -b;
21        }
22
23        int result = 0;
24
25        while (a <= b) {
26
27            int current = b;
28            int count = -1;
29
30            // Double divisor using addition
31            while (current >= -1073741824 &&
32                   a <= current + current) {
33
34                current += current;
35                count += count;
36            }
37
38            a -= current;
39            result += count;
40        }
41
42        return negative ? result : -result;
43    }
44}