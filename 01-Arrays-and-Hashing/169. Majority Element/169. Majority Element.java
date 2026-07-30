1class Solution {
2    public int majorityElement(int[] nums) {
3        int ans = 0; int frequency = 0;
4        for(int i = 0; i<nums.length;i++){
5            if(frequency == 0) ans = nums[i];
6            if(ans == nums[i]) frequency++;
7            else frequency--;
8        }
9        return ans;
10    }
11}