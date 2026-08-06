1class Solution {
2    
3
4    public int rob(int[] nums) {
5        int n = nums.length;
6
7        if(nums.length == 1) return nums[0];
8        if(nums.length == 2) return Math.max(nums[0], nums[1]);
9
10        return Math.max(
11        helper(nums, 0,n-2), helper(nums,1,n-1));
12    }
13
14
15    public int helper(int[] nums,int st, int end) {
16        int n = nums.length;
17        int dp [] = new int[n-1];
18        if(n == 1) return nums[0];
19
20        dp[0] = nums[st];
21        dp[1] = Math.max(nums[st] , nums[st+1]);
22
23        for(int i=st+2, j=2; i<=end;j++, i++){
24            dp[j] = Math.max(dp[j-1],dp[j-2]+nums[i]);
25        }
26        return dp[n-2];
27
28    }
29}