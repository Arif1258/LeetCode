1class Solution {
2    public int maxSubArray(int[] nums) {
3        int currSum = 0;
4        int maxSum = Integer.MIN_VALUE;
5
6        for(int i =0; i<nums.length;i++){
7            currSum += nums[i];
8            maxSum = Math.max(maxSum, currSum);
9
10            if(currSum < 0){
11                currSum = 0;
12            }
13        }
14        return maxSum;
15    }
16}