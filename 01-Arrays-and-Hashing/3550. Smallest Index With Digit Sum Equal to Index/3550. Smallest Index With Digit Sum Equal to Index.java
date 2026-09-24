1class Solution {
2    public int smallestIndex(int[] nums) {
3        for(int i=0; i<nums.length;i++){
4            int sum = 0;
5            int n = nums[i];
6            while(n > 0){
7                int r = n % 10;
8                sum += r;
9                n = n/10;
10
11            }
12            if(i == sum) return i;
13        }
14        return -1;
15
16    }
17}