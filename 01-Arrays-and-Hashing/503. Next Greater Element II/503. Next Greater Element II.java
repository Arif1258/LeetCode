1class Solution {
2    public int[] nextGreaterElements(int[] nums) {
3        int n = nums.length;
4        Stack<Integer> s = new Stack<>();
5        int ans [] = new int[n];
6
7        for(int i = 2*n -1; i>=0;i--){
8            while(!s.isEmpty() && nums[s.peek()] <= nums[i%n]){
9                s.pop();
10            }
11            if(i < n){
12                ans[i%n] = s.isEmpty()? -1: nums[s.peek()];
13            }
14            s.push(i%n);
15        }
16        return ans;
17    }
18}