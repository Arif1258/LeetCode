1class Solution {
2    public int findTargetSumWays(int[] nums, int target) {
3        int sum = 0;
4        for (int num : nums) {
5            sum += num;
6        }
7        if (Math.abs(target) > sum) return 0;
8        if ((sum - target) % 2 != 0) return 0;
9        int required = (sum - target) / 2;
10        int[] dp = new int[required + 1];
11        dp[0] = 1;
12        for (int num : nums) {
13            for (int j = required; j >= num; j--) {
14                dp[j] += dp[j - num];
15            }
16        }
17        return dp[required];
18    }
19}