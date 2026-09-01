1class Solution {
2    public int minimumTotal(List<List<Integer>> triangle) {
3        int n = triangle.size();
4        int[] dp = new int[n];
5
6        for (int i = 0; i < n; i++) {
7            dp[i] = triangle.get(n - 1).get(i);
8        }
9
10        for (int i = n - 2; i >= 0; i--) {
11            for (int j = 0; j <= i; j++) {
12                dp[j] = triangle.get(i).get(j)
13                        + Math.min(dp[j], dp[j + 1]);
14            }
15        }
16
17        return dp[0];
18    }
19}