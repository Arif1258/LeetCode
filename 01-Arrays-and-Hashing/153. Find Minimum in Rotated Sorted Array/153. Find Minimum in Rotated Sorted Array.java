1class Solution {
2    public int findMin(int[] nums) {
3        int left = 0;
4        int right = nums.length - 1;
5
6        while (left < right) {
7            int mid = left + (right - left) / 2;
8
9            if (nums[mid] > nums[right]) {
10                // Minimum is on the right side
11                left = mid + 1;
12            } else {
13                // Minimum is at mid or on the left side
14                right = mid;
15            }
16        }
17
18        return nums[left];
19    }
20}