1import java.util.HashMap;
2
3class Solution {
4    public int[] twoSum(int[] nums, int target) {
5        HashMap<Integer, Integer> map = new HashMap<>();
6        
7        for (int i = 0; i < nums.length; i++) {
8            int first = nums[i];
9            int second = target - first;
10
11            if (map.containsKey(second)) {
12                return new int[]{map.get(second), i};
13            }
14
15            map.put(first, i);
16        }
17        return new int[]{};
18    }
19}