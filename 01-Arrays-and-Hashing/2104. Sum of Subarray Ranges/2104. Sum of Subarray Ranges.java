1class Solution {
2    public long subArrayRanges(int[] nums) {
3        long sum = 0;
4        for (int i = 0; i < nums.length; i++) {
5            int largest = nums[i];
6            int smallest = nums[i];
7
8            for (int j = i + 1; j < nums.length; j++) {
9                largest = Math.max(largest, nums[j]);
10                smallest = Math.min(smallest, nums[j]);
11                sum += (long) largest - smallest;
12            }
13        }
14        return sum;
15    }
16}