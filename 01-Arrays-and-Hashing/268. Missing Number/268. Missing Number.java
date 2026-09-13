1class Solution {
2    public int missingNumber(int[] nums) {
3        int n = nums.length;
4        int xor = n;
5
6        for(int i=0; i<n;i++){
7            xor = xor ^ i ^ nums[i];
8        }
9        return xor;
10    }
11}