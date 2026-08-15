1class Solution {
2    public int longestSubsequence(int[] nums) {
3        int xor = 0;
4        for (int num : nums) {
5            xor ^= num;
6        }
7        if (xor != 0) {
8            return nums.length;
9        }
10        for (int num : nums) {
11            if (num != 0) {
12                return nums.length - 1;
13            }
14        }
15        return 0;
16    }
17}