1class Solution {
2    public int findMaxLength(int[] nums) {
3        HashMap<Integer, Integer> map = new HashMap<>();
4        map.put(0, -1);
5
6        int sum = 0;
7        int maxLength = 0;
8        for (int i = 0; i < nums.length; i++) {
9            if (nums[i] == 0) {
10                sum--;
11            } else {
12                sum++;
13            }
14            if (map.containsKey(sum)) {
15                maxLength = Math.max(maxLength, i - map.get(sum));
16            } else {
17                map.put(sum, i);
18            }
19        }
20
21        return maxLength;
22    }
23}