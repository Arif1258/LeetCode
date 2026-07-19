1class Solution {
2    public int[] nextGreaterElements(int[] nums) {
3        int n = nums.length;
4        Stack<Integer> s = new Stack<>();
5        int ans [] = new int[n];
6
7        for(int i = 2*n -1; i>=0;i--){
8            while(s.size() > 0 && nums[s.peek()] <= nums[i%n]){
9                s.pop();
10            }
11            ans[i%n] = s.isEmpty()? -1: nums[s.peek()];
12            s.push(i%n);
13        }
14        return ans;
15    }
16}