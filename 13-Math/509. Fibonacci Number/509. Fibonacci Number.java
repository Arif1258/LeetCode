1class Solution {
2    public int fib(int n) {
3        if (n <= 1) {
4            return n;
5        }
6
7        int[] dp = new int[n + 1];
8
9        int prev2 = 0;
10        int prev1 = 1;
11
12        for (int i = 2; i <= n; i++) {
13            int current = prev1 + prev2;
14            prev2 = prev1;
15            prev1 = current;
16        }
17
18        return prev1;
19    }
20}