1class Solution {
2    public int longestMonotonicSubarray(int[] nums) {
3        int inc = 1, dec = 1;
4        int ans = 1;
5
6        for (int i = 1; i < nums.length; i++) {
7            if (nums[i] > nums[i - 1]) {
8                inc++;
9                dec = 1;
10            } 
11            else if (nums[i] < nums[i - 1]) {
12                dec++;
13                inc = 1;
14            } 
15            else {
16                inc = 1;
17                dec = 1;
18            }
19
20            ans = Math.max(ans, Math.max(inc, dec));
21        }
22
23        return ans;
24    }
25}
26