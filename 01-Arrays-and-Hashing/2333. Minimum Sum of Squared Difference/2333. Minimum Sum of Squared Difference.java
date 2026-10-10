1class Solution {
2    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
3        long k = (long) k1 + k2;
4        int n = nums1.length;
5        int[] diff = new int[n];
6        int maxDiff = 0;
7        long total = 0;
8
9        for (int i = 0; i < n; i++) {
10            diff[i] = Math.abs(nums1[i] - nums2[i]);
11            maxDiff = Math.max(maxDiff, diff[i]);
12            total += diff[i];
13        }
14
15        if (k >= total) {
16            return 0L;
17        }
18
19        int left = 0, right = maxDiff;
20
21        while (left < right) {
22            int mid = left + (right - left) / 2;
23            long needed = 0;
24
25            for (int d : diff) {
26                if (d > mid) {
27                    needed += d - mid;
28                }
29            }
30
31            if (needed <= k) {
32                right = mid;
33            } else {
34                left = mid + 1;
35            }
36        }
37        int level = left;
38        long remaining = k;
39        for (int d : diff) {
40            if (d > level) {
41                remaining -= d - level;
42            }
43        }
44        long ans = 0;
45        for (int d : diff) {
46            int reduced = Math.min(d, level);
47            ans += (long) reduced * reduced;
48        }
49
50        if (remaining > 0) {
51            ans -= remaining * (2L * level - 1);
52        }
53
54        return ans;
55    }
56}