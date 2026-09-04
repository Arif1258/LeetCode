1class Solution {
2    public int firstStableIndex(int[] nums, int k) {
3        int n = nums.length;
4        int[] suffixMin = new int[n];
5        suffixMin[n - 1] = nums[n - 1];
6
7        for (int i = n - 2; i >= 0; i--) {
8            suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
9        }
10        int prefixMax = nums[0];
11        for (int i = 0; i < n; i++) {
12            prefixMax = Math.max(prefixMax, nums[i]);
13
14            int instability = prefixMax - suffixMin[i];
15
16            if (instability <= k) {
17                return i;
18            }
19        }
20
21        return -1;
22    }
23}