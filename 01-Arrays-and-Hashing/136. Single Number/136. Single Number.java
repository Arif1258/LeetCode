1class Solution {
2    public int singleNumber(int[] nums) {
3        int n = 0;
4
5        for(int i=0; i<nums.length;i++){
6            n = n ^ nums[i];
7
8        }
9        return n;
10    }
11}