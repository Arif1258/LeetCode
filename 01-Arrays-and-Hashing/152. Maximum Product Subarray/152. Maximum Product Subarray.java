1class Solution {
2    public int maxProduct(int[] nums) {
3        int n  = nums.length;
4        int prefix = 1;
5        int suffix = 1;
6        int ans = Integer.MIN_VALUE;
7
8        for(int i=0; i<n;i++){
9            if(prefix == 0) prefix = 1;
10            if(suffix == 0) suffix = 1;
11
12            prefix *= nums[i];
13            suffix *= nums[n-1-i];
14
15            ans = Math.max(ans, Math.max(prefix, suffix));
16        }
17        return ans;
18    }
19}