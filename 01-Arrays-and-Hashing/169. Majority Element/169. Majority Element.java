1class Solution {
2    public int majorityElement(int[] nums) {
3        int majority = nums[0];
4        int votes = 1;
5
6        for(int i=1; i<nums.length;i++){
7            if(votes == 0){
8                votes++;
9                majority = nums[i];
10            }else if(majority == nums[i]){
11                votes++;
12            }else{
13                votes--;
14            }
15        }
16        return majority;
17    }
18}