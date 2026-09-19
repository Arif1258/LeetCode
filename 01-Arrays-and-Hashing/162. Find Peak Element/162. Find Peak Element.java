1class Solution {
2    public int findPeakElement(int[] nums) {
3        int left = 0;
4        int right = nums.length-1;
5
6        while(left < right){
7            int mid = left + (right-left)/2;
8
9           if(nums[mid] > nums[mid+1]){
10                right = mid;
11           }else{
12            left = mid+1;
13           }
14        }
15        return left;
16    }
17}