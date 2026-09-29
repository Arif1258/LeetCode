1class Solution {
2    public int minKBitFlips(int[] nums, int k) {
3        int n = nums.length;
4        int[] diff = new int[n + 1];
5        int flip = 0;
6        int ans = 0;
7        
8        for (int i = 0; i < n; i++) {
9            flip ^= diff[i];
10            if (nums[i] == flip) {
11                if (i + k > n) {
12                    return -1;
13                }
14                ans++;
15                flip ^= 1;
16                diff[i + k] ^= 1;
17            }
18        }
19
20        return ans;
21    }
22}