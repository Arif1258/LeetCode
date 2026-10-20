1
2class Solution {
3    public int sortableIntegers(int[] nums) {
4        int n = nums.length;
5        int[] prefMax = new int[n + 1];
6        for (int i = 0; i < n; i++) {
7            prefMax[i + 1] = Math.max(prefMax[i], nums[i]);
8        }
9        int[] suffMin = new int[n + 1];
10        suffMin[n] = Integer.MAX_VALUE;
11
12        for (int i = n - 1; i >= 0; i--) {
13            suffMin[i] = Math.min(nums[i], suffMin[i + 1]);
14        }
15        int[] prefDrop = new int[n];
16
17        for (int i = 1; i < n; i++) {
18            prefDrop[i] = prefDrop[i - 1];
19
20            if (nums[i - 1] > nums[i]) {
21                prefDrop[i]++;
22            }
23        }
24
25        int ans = 0;
26        for (int d = 1; d <= n / d; d++) {
27            if (n % d == 0) {
28                if (check(nums, prefMax, suffMin, prefDrop, d)) {
29                    ans += d;
30                }
31
32                int other = n / d;
33
34                if (other != d &&
35                    check(nums, prefMax, suffMin, prefDrop, other)) {
36                    ans += other;
37                }
38            }
39        }
40
41        return ans;
42    }
43
44    private boolean check(
45        int[] nums,
46        int[] prefMax,
47        int[] suffMin,
48        int[] prefDrop,
49        int k
50    ) {
51        int n = nums.length;
52
53        for (int start = 0; start < n; start += k) {
54            int end = start + k - 1;
55            int drops = prefDrop[end] - prefDrop[start];
56            if (nums[end] > nums[start]) {
57                drops++;
58            }
59            if (drops > 1) {
60                return false;
61            }
62            if (prefMax[start] > suffMin[start]) {
63                return false;
64            }
65        }
66
67        return true;
68    }
69}
70