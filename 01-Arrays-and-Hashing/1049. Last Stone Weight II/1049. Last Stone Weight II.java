1
2class Solution {
3    public int lastStoneWeightII(int[] stones) {
4        int total = 0;
5        for (int stone : stones) {
6            total += stone;
7        }
8
9        int target = total / 2;
10        boolean[] dp = new boolean[target + 1];
11        dp[0] = true;
12        for (int stone : stones) {
13            for (int j = target; j >= stone; j--) {
14                dp[j] = dp[j] || dp[j - stone];
15            }
16        }
17
18        for (int j = target; j >= 0; j--) {
19            if (dp[j]) {
20                return total - 2 * j;
21            }
22        }
23
24        return 0;
25    }
26}
27