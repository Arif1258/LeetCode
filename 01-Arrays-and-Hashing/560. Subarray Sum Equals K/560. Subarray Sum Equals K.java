1class Solution {
2    public int subarraySum(int[] nums, int k) {
3        int count = 0;
4        int prefixSum[] = new int[nums.length];
5        prefixSum[0] = nums[0];
6        for (int i = 1; i < nums.length; i++) {
7            prefixSum[i] = prefixSum[i - 1] + nums[i];
8        }
9        HashMap<Integer, Integer> map = new HashMap<>();
10        for (int j = 0; j < nums.length; j++) {
11            if (prefixSum[j] == k) {
12                count++;
13            }
14            int val = prefixSum[j] - k;
15            if (map.containsKey(val)) {
16                count += map.get(val);
17            }
18            map.put(prefixSum[j], map.getOrDefault(prefixSum[j], 0) + 1);
19        }
20        return count;
21    }
22}