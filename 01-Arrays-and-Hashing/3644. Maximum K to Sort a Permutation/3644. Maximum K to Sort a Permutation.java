1class Solution {
2    public int sortPermutation(int[] nums) {
3        int ans = -1;
4
5        for (int i = 0; i < nums.length; i++) {
6            if (nums[i] != i) {
7                ans &= nums[i];
8            }
9        }
10
11        return Math.max(ans, 0);
12    }
13}
14