1class Solution {
2    public int minOperations(int[] nums) {
3        int n = nums.length;
4        int zero = 0;
5        for (int i = 0; i < n; i++) {
6            if (nums[i] == 0) {
7                zero = i;
8                break;
9            }
10        }
11
12        int ans = Integer.MAX_VALUE;
13        if (check(nums, zero, 1)) {
14            ans = Math.min(ans, zero);
15            ans = Math.min(ans, n - zero + 2);
16        }
17        if (check(nums, zero, -1)) {
18            ans = Math.min(ans, zero + 2);
19            ans = Math.min(ans, n - zero);
20        }
21
22        return ans == Integer.MAX_VALUE ? -1 : ans;
23    }
24
25    private boolean check(int[] nums, int zero, int step) {
26        int n = nums.length;
27
28        for (int i = 1; i < n; i++) {
29            int prev = (zero + (i - 1) * step + n) % n;
30            int curr = (zero + i * step + n) % n;
31
32            if (nums[prev] > nums[curr]) {
33                return false;
34            }
35        }
36
37        return true;
38    }
39}