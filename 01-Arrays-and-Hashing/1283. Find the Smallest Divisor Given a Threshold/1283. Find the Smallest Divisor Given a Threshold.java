1class Solution {
2    public int smallestDivisor(int[] nums, int threshold) {
3        int low = 1;
4        int high = 0;
5
6        for (int num : nums) {
7            high = Math.max(high, num);
8        }
9
10        int ans = high;
11
12        while (low <= high) {
13            int mid = low + (high - low) / 2;
14
15            if (isValid(nums, mid, threshold)) {
16                ans = mid;
17                high = mid - 1;
18            } else {
19                low = mid + 1;
20            }
21        }
22
23        return ans;
24    }
25
26    private boolean isValid(int[] nums, int divisor, int threshold) {
27        int sum = 0;
28
29        for (int num : nums) {
30            sum += (num + divisor - 1) / divisor;
31
32            if (sum > threshold) {
33                return false;
34            }
35        }
36
37        return true;
38    }
39}