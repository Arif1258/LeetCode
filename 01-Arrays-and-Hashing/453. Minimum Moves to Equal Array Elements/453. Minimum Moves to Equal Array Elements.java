1class Solution {
2    public int minMoves(int[] nums) {
3        int min = Integer.MAX_VALUE;
4        long sum = 0;
5        for (int x : nums) {
6            sum += x;
7            min = Math.min(min, x);
8        }
9        return (int)(sum - (long)min * nums.length);
10    }
11}