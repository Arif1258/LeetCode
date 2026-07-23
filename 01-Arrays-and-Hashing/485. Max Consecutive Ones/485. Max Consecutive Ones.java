1class Solution {
2    public int findMaxConsecutiveOnes(int[] nums) {
3        int currSum = 0;
4        int maxSum = Integer.MIN_VALUE;
5        for(int i =0; i<nums.length;i++){
6            currSum += nums[i];
7            maxSum = Math.max(maxSum, currSum);
8
9            if(nums[i] == 0) currSum = 0;
10        }
11        return maxSum;
12    }
13}