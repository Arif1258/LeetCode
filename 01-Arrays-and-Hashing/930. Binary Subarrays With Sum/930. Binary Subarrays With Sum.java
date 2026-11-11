1class Solution {
2    public int numSubarraysWithSum(int[] nums, int goal) {
3        return atMost(nums, goal) - atMost(nums, goal - 1);
4    }
5
6    private int atMost(int[] nums, int goal) {
7        if (goal < 0) return 0;
8        int count = 0;
9        int sum = 0;
10        int left = 0;
11        for (int right = 0; right < nums.length; right++) {
12            sum += nums[right];
13            while (sum > goal) {
14                sum -= nums[left];
15                left++;
16            }
17            count += right - left + 1;
18        }
19
20        return count;
21    }
22}
23