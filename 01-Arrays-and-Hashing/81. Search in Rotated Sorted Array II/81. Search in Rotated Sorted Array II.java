1class Solution {
2    public boolean search(int[] nums, int target) {
3        int left = 0;
4        int right = nums.length - 1;
5
6        while (left <= right) {
7            int mid = left + (right - left) / 2;
8
9            if (nums[mid] == target) {
10                return true;
11            }
12
13            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
14                left++;
15                right--;
16            } 
17            else if (nums[left] <= nums[mid]) {
18                if (nums[left] <= target && target < nums[mid]) {
19                    right = mid - 1;
20                } else {
21                    left = mid + 1;
22                }
23            } 
24            else {
25                if (nums[mid] < target && target <= nums[right]) {
26                    left = mid + 1;
27                } else {
28                    right = mid - 1;
29                }
30            }
31        }
32
33        return false;
34    }
35}