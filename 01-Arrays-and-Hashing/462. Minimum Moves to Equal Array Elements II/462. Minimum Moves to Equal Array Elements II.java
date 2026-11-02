1class Solution {
2    public int minMoves2(int[] nums) {
3        int n = nums.length;
4        Arrays.sort(nums);
5        int median = nums[n/2];
6        int moves = 0;
7        for(int num : nums){
8            moves += Math.abs(num - median);
9        }
10        return moves;
11    }
12}