1class Solution {
2    public int splitArray(int[] nums, int k) {
3        int low = 0;
4        int high = 0;
5
6        for (int num : nums) {
7            low = Math.max(low, num);
8            high += num;
9        }
10        int ans = high;
11        while (low <= high) {
12            int mid = low + (high - low) / 2;
13            if (canSplit(nums, k, mid)) {
14                ans = mid;
15                high = mid - 1;
16            } else {
17                low = mid + 1;
18            }
19        }
20
21        return ans;
22    }
23
24    private boolean canSplit(int[] nums, int k, int maxSum) {
25
26        int count = 1;
27        int sum = 0;
28
29        for (int num : nums) {
30
31            if (sum + num > maxSum) {
32                count++;
33                sum = num;
34            } else {
35                sum += num;
36            }
37
38            if (count > k) {
39                return false;
40            }
41        }
42
43        return true;
44    }
45}
46