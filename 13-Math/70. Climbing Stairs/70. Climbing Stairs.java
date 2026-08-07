1class Solution {
2    public int climbStairs(int n) {
3        if(n <= 2) return n;
4        int prev2 = 1;
5        int prev1 = 2;
6        for(int i = 3; i<=n;i++){
7            int current = prev1 + prev2;
8            prev2 = prev1;
9            prev1 = current;
10        }
11        return prev1;
12    }
13}