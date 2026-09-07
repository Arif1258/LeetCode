1class Solution {
2    public int searchInsert(int[] nums, int target) {
3        int left = 0;
4        int right = nums.length - 1;
5        int ans = nums.length;
6
7        while (left <= right) {
8            int mid = left + (right - left) / 2;
9
10            if (nums[mid] >= target) {
11                ans = mid;
12                right = mid - 1;
13            } else {
14                left = mid + 1;
15            }
16        }
17        return ans;
18    }
19}