1class Solution {
2    public List<Integer> targetIndices(int[] nums, int target) {
3        Arrays.sort(nums);
4
5        List<Integer> result = new ArrayList<>();
6
7        for (int i = 0; i < nums.length; i++) {
8            if (nums[i] == target) {
9                result.add(i);
10            }
11        }
12
13        return result;
14    }
15}
16