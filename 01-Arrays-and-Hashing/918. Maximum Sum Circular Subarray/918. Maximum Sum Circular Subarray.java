1class Solution {
2    public int maxSubarraySumCircular(int[] nums) {
3        int sum = 0;
4        int max = nums[0];
5        int min = nums[0];
6        int currMax = 0;
7        int currMin = 0;
8
9        for (int i = 0; i < nums.length; i++) {
10            sum += nums[i];
11
12            currMax += nums[i];
13            if (currMax > max) max = currMax;
14            if (currMax < 0) currMax = 0;
15
16            currMin += nums[i];
17            if (currMin < min) min = currMin;
18            if (currMin > 0) currMin = 0;
19        }
20
21        if (max < 0) return max;
22
23        return Math.max(max, sum - min);
24    }
25}