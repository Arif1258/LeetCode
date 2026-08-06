1class Solution {
2    public int rob(int[] nums) {
3        int n = nums.length;
4        int dp [] = new int[n];
5
6        if(n == 1) return nums[0];
7
8        int prev1 = nums[0];
9        int prev2 = Math.max(nums[0] , nums[1]);
10        int result = prev2;
11
12        for(int i=2; i<n; i++){
13            result = Math.max(prev2,prev1+nums[i]);
14            prev1=prev2;
15            prev2=result;
16        }
17        return result;
18
19    }
20}