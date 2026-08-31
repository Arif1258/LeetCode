1class Solution {
2    public int combinationSum4(int[] nums, int target) {
3        int[] dp = new int[target + 1];
4
5        dp[0] = 1;
6
7        for (int i = 1; i <= target; i++) {
8            for (int num : nums) {
9                if (i >= num) {
10                    dp[i] += dp[i - num];
11                }
12            }
13        }
14
15        return dp[target];
16    }
17    
18}