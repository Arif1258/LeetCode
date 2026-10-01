1class Solution {
2    public int thirdMax(int[] nums) {
3        long first = Long.MIN_VALUE;
4        long second = Long.MIN_VALUE;
5        long third = Long.MIN_VALUE;
6
7        for (int num : nums) {
8            if (num == first || num == second || num == third) {
9                continue;
10            }
11
12            if (num > first) {
13                third = second;
14                second = first;
15                first = num;
16            } else if (num > second) {
17                third = second;
18                second = num;
19            } else if (num > third) {
20                third = num;
21            }
22        }
23
24        return third == Long.MIN_VALUE ? (int) first : (int) third;
25    }
26}