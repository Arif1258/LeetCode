1class Solution {
2    public int search(int[] nums, int target) {
3        int left = 0;
4        int right = nums.length - 1;
5
6        while (left <= right) {
7            int mid = left + (right - left) / 2;
8
9            if (nums[mid] == target) {
10                return mid;
11            }
12
13            if (target > nums[mid]) {
14                left = mid + 1;
15            } else {
16                right = mid - 1;
17            }
18        }
19
20        return -1;
21    }
22}