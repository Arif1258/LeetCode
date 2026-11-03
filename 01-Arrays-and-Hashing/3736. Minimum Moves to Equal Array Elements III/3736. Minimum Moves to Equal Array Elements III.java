1class Solution {
2    public int minMoves(int[] nums) {
3        int max = 0;
4        int sum = 0;
5
6        for (int num : nums) {
7            max = Math.max(max, num);
8            sum += num;
9        }
10
11        return max * nums.length - sum;
12    }
13}