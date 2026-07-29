1class Solution {
2    public int maxProduct(int[] nums) {
3        int maxP = nums[0];
4        int minP = nums[0];
5        int ans = nums[0];
6
7        for (int i = 1; i < nums.length; i++) {
8            if (nums[i] < 0) {
9                int temp = maxP;
10                maxP = minP;
11                minP = temp;
12            }
13            maxP = Math.max(nums[i], nums[i] * maxP);
14            minP = Math.min(nums[i], nums[i] * minP);
15            ans = Math.max(ans, maxP);
16        }
17
18        return ans;
19
20    }
21}