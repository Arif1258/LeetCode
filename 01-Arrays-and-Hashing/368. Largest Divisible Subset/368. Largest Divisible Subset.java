1class Solution {
2    public List<Integer> largestDivisibleSubset(int[] nums) {
3        int n = nums.length;
4        if (n == 0) return new ArrayList<>();
5        Arrays.sort(nums);
6        int[] dp = new int[n];
7        int[] prev = new int[n];
8        Arrays.fill(dp, 1);
9        Arrays.fill(prev, -1);
10        int ans = 1, lastIndex = 0;
11
12        for (int i = 1; i < n; i++) {
13            for (int j = 0; j < i; j++) {
14                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
15                    dp[i] = dp[j] + 1;
16                    prev[i] = j;
17                }
18            }
19            if (dp[i] > ans) {
20                ans = dp[i];
21                lastIndex = i;
22            }
23        }
24        List<Integer> result = new ArrayList<>();
25        while (lastIndex != -1) {
26            result.add(nums[lastIndex]);
27            lastIndex = prev[lastIndex];
28        }
29        return result;
30    }
31}