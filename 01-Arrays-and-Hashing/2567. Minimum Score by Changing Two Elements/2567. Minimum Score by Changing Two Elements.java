1class Solution {
2    public int minimizeSum(int[] nums) {
3        Arrays.sort(nums);
4
5        int n = nums.length;
6
7        return Math.min(
8            nums[n - 1] - nums[2],
9            Math.min(
10                nums[n - 2] - nums[1],
11                nums[n - 3] - nums[0]
12            )
13        );
14    }
15}
16