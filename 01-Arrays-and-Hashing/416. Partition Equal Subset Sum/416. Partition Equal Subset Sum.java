1
2class Solution {
3    public boolean canPartition(int[] nums) {
4        int sum = 0;
5        for (int num : nums) {
6            sum += num;
7        }
8        if (sum % 2 != 0) {
9            return false;
10        }
11        int target = sum / 2;
12        boolean[] dp = new boolean[target + 1];
13        dp[0] = true;
14
15        for (int num : nums) {
16            for (int j = target; j >= num; j--) {
17                dp[j] = dp[j] || dp[j - num];
18            }
19        }
20
21        return dp[target];
22    }
23}
24