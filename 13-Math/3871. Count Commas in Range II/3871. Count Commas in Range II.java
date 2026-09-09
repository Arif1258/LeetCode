1class Solution {
2    public long countCommas(long n) {
3        long ans = 0;
4        long x = 1000;
5
6        while (x <= n) {
7            ans += n - x + 1;
8            x *= 1000;
9        }
10
11        return ans;
12    }
13}
14
15