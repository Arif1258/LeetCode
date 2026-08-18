1class Solution {
2    public int numTrees(int n) {
3        int dp [] = new int [n+1];
4        dp[0] = 1;
5        dp[1] = 1;
6
7
8        for(int i=2; i<=n;i++){
9            for(int j=0; j<i; j++){
10                dp[i] += dp[j] * dp[i-j-1];
11            }
12        }
13        return dp[n];
14    }
15}