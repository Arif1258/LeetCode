1class Solution {
2    public int maxProductDifference(int[] nums) {
3        int max1 = Integer.MIN_VALUE;
4        int max2 = Integer.MIN_VALUE;
5        int min1 = Integer.MAX_VALUE;
6        int min2 = Integer.MAX_VALUE;
7
8        for (int n : nums) {
9            if (n > max1) {
10                max2 = max1;
11                max1 = n;
12            } else if (n > max2) {
13                max2 = n;
14            }
15
16            if (n < min1) {
17                min2 = min1;
18                min1 = n;
19            } else if (n < min2) {
20                min2 = n;
21            }
22        }
23    return (max1 * max2) - (min1 * min2);
24    }
25}