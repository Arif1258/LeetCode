1class Solution {
2    public int numberOfSubarrays(int[] nums, int k) {
3        return atMost(nums, k) - atMost(nums, k - 1);
4    }
5
6    private int atMost(int[] nums, int k) {
7        if (k < 0) return 0;
8        int count = 0;
9        int sum = 0;
10        int left = 0;
11        for (int right = 0; right < nums.length; right++) {
12            sum += (nums[right]) % 2;
13            while (sum > k) {
14                sum -= (nums[left]) % 2;
15                left++;
16            }
17            count += right - left + 1;
18        }
19
20        return count;
21    }
22}
23