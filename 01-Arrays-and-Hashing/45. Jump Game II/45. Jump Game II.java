1class Solution {
2    public int jump(int[] nums) {
3        int jumps = 0;
4        int currentEnd = 0;
5        int farthest = 0;
6
7        for (int i = 0; i < nums.length - 1; i++) {
8
9
10            farthest = Math.max(farthest, i + nums[i]);
11            if (i == currentEnd) {
12                jumps++;
13                currentEnd = farthest;
14            }
15        }
16
17        return jumps;
18    }
19}