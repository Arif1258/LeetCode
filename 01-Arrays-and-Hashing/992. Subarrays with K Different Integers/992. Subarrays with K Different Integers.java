1class Solution {
2    public int subarraysWithKDistinct(int[] nums, int k) {
3        return atMost(nums, k) - atMost(nums, k - 1);
4    }
5
6    private int atMost(int[] nums, int k) {
7        int left = 0;
8        int count = 0;
9        HashMap<Integer, Integer> map = new HashMap<>();
10        for (int right = 0; right < nums.length; right++) {
11            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
12            while (map.size() > k) {
13                map.put(nums[left], map.get(nums[left]) - 1);
14                if (map.get(nums[left]) == 0) {
15                    map.remove(nums[left]);
16                }
17                left++;
18            }
19            count += right - left + 1;
20        }
21
22        return count;
23    }
24}
25