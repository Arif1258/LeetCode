1
2class Solution {
3    public int sumCounts(List<Integer> nums) {
4        int n = nums.size();
5        int ans = 0;
6
7        for (int i = 0; i < n; i++) {
8            Set<Integer> distinct = new HashSet<>();
9
10            for (int j = i; j < n; j++) {
11                distinct.add(nums.get(j));
12
13                int count = distinct.size();
14                ans += count * count;
15            }
16        }
17
18        return ans;
19    }
20}
21