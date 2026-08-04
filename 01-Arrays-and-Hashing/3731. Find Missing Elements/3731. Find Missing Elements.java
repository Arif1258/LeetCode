1class Solution {
2    public List<Integer> findMissingElements(int[] nums) {
3        int min = Integer.MAX_VALUE;
4        int max = Integer.MIN_VALUE;
5        HashSet<Integer> seen = new HashSet<>();
6        for (int num : nums) {
7            min = Math.min(min, num);
8            max = Math.max(max, num);
9            seen.add(num);
10        }
11        List<Integer> ans = new ArrayList<>();
12        for (int value = min + 1; value < max; value++) {
13            if (!seen.contains(value)) {
14                ans.add(value);
15            }
16        }
17        return ans;
18    }
19}