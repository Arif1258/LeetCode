1class Solution {
2    public int maxSelectedElements(int[] nums) {
3        Arrays.sort(nums);
4
5        Map<Integer, Integer> dp = new HashMap<>();
6        int ans = 0;
7
8        for (int num : nums) {
9            int len = dp.getOrDefault(num, 0) + 1;
10
11            int prev = dp.getOrDefault(num - 1, 0) + 1;
12
13            dp.put(num + 1, Math.max(dp.getOrDefault(num + 1, 0), len));
14            dp.put(num, Math.max(dp.getOrDefault(num, 0), prev));
15
16            ans = Math.max(ans, Math.max(len, prev));
17        }
18
19        return ans;
20    }
21}