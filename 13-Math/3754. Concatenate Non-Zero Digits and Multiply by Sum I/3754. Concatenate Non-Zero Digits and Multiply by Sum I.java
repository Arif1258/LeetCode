1class Solution {
2    public long sumAndMultiply(int n) {
3        long x = 0;
4        int sum = 0;
5        long place = 1;
6        while (n > 0) {
7            int digit = n % 10;
8            if (digit != 0) {
9                x += digit * place;
10                place *= 10;
11                sum += digit;
12            }
13            n /= 10;
14        }
15        return x * sum;
16    }
17}