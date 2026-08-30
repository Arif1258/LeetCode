1class Solution {
2    public int longestOnes(int[] nums, int k) {
3        int left =0;
4        int zero = 0;
5        int maxLength = 0;
6
7        for(int right=0; right<nums.length;right++){
8            if(nums[right] == 0){
9                zero++;
10            }
11            while(zero > k){
12                if(nums[left] == 0){
13                    zero--;
14                    
15                }
16                left++;
17
18            }
19            maxLength = Math.max(maxLength, right-left+1);
20        }
21        return maxLength;
22    }
23}