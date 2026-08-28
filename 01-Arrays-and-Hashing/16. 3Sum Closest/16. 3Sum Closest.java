1class Solution {
2    public int threeSumClosest(int[] nums, int target) {
3
4        Arrays.sort(nums);
5
6        int closest = nums[0] + nums[1] + nums[2];
7
8        for (int i = 0; i < nums.length - 2; i++) {
9            int left = i + 1;
10            int right = nums.length - 1;
11
12            while (left < right) {
13                int sum = nums[i] + nums[left] + nums[right];
14                if (sum == target) {
15                    return sum;
16                }
17
18                if (Math.abs(sum - target) < Math.abs(closest - target)) {
19                    closest = sum;
20                }
21                if (sum < target) {
22                    left++;
23                } else {
24                    right--;
25                }
26            }
27        }
28
29        return closest;
30    }
31}