1class Solution {
2    public int mySqrt(int x) {
3
4        if (x < 2) {
5            return x;
6        }
7
8        int answer = 0;
9
10        for (int i = 1; i <= x / i; i++) {
11            answer = i;
12        }
13
14        return answer;
15    }
16}