1class Solution {
2    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
3        int n = nums.size();
4        int ans = Integer.MAX_VALUE;
5
6        for (int i = 0; i < n; i++) {
7            int sum = 0;
8            for (int j = i; j < n && j - i + 1 <= r; j++) {
9                sum += nums.get(j);
10                int len = j - i + 1;
11                if (len >= l && sum > 0) {
12                    ans = Math.min(ans, sum);
13                }
14            }
15        }
16
17        return ans == Integer.MAX_VALUE ? -1 : ans;
18    }
19}
20