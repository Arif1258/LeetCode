1
2import java.util.Arrays;
3
4class Solution {
5    public long maxAlternatingSum(int[] nums) {
6        int n = nums.length;
7        for (int i = 0; i < n; i++) {
8            nums[i] = nums[i] * nums[i];
9        }
10        Arrays.sort(nums);
11
12        long ans = 0;
13        int half = n / 2;
14        for (int i = 0; i < half; i++) {
15            ans -= nums[i];
16        }
17        for (int i = half; i < n; i++) {
18            ans += nums[i];
19        }
20
21        return ans;
22    }
23}
24