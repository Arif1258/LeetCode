1class Solution {
2    public int missingMultiple(int[] nums, int k) {
3        Set<Integer> set = new HashSet<>();
4
5        for (int num : nums) {
6            set.add(num);
7        }
8
9        int multiple = k;
10
11        while (set.contains(multiple)) {
12            multiple += k;
13        }
14
15        return multiple;
16    }
17}