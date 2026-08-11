1class Solution {
2    public int missingInteger(int[] nums) {
3        int sum = nums[0];
4        for (int i = 1; i < nums.length; i++) {
5            if (nums[i] == nums[i - 1] + 1) {
6                sum += nums[i];
7            } else {
8                break;
9            }
10        }
11        Set<Integer> set = new HashSet<>();
12        for (int num : nums) {
13            set.add(num);
14        }
15        while (set.contains(sum)) {
16            sum++;
17        }
18        return sum;
19    }
20}