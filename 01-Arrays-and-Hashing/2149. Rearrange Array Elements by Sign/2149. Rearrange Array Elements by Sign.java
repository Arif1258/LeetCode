1class Solution {
2    public int[] rearrangeArray(int[] nums) {
3        int[] ans = new int[nums.length];
4
5        int pos = 0;
6        int neg = 1;
7
8        for (int num : nums) {
9            if (num > 0) {
10                ans[pos] = num;
11                pos += 2;
12            } else {
13                ans[neg] = num;
14                neg += 2;
15            }
16        }
17
18        return ans;
19    }
20}