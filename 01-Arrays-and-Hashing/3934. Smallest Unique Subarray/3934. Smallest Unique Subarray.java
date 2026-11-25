1
2import java.util.*;
3
4class Solution {
5    private static final long MOD1 = 1_000_000_007L;
6    private static final long MOD2 = 1_000_000_009L;
7    private static final long BASE = 100_003L;
8
9    public int smallestUniqueSubarray(int[] nums) {
10        int n = nums.length;
11
12        long[] pow1 = new long[n + 1];
13        long[] pow2 = new long[n + 1];
14
15        pow1[0] = 1;
16        pow2[0] = 1;
17
18        for (int i = 1; i <= n; i++) {
19            pow1[i] = pow1[i - 1] * BASE % MOD1;
20            pow2[i] = pow2[i - 1] * BASE % MOD2;
21        }
22
23        long[] hash1 = new long[n + 1];
24        long[] hash2 = new long[n + 1];
25
26        for (int i = 0; i < n; i++) {
27            hash1[i + 1] =
28                (hash1[i] * BASE + nums[i]) % MOD1;
29
30            hash2[i + 1] =
31                (hash2[i] * BASE + nums[i]) % MOD2;
32        }
33
34        int left = 1;
35        int right = n;
36
37        while (left < right) {
38            int mid = left + (right - left) / 2;
39
40            if (check(mid, n, hash1, hash2, pow1, pow2)) {
41                right = mid;
42            } else {
43                left = mid + 1;
44            }
45        }
46
47        return left;
48    }
49
50    private boolean check(
51        int len,
52        int n,
53        long[] hash1,
54        long[] hash2,
55        long[] pow1,
56        long[] pow2
57    ) {
58        HashMap<Long, Integer> map = new HashMap<>();
59
60        for (int i = 0; i + len <= n; i++) {
61
62            long h1 = (
63                hash1[i + len] -
64                hash1[i] * pow1[len] % MOD1 +
65                MOD1
66            ) % MOD1;
67
68            long h2 = (
69                hash2[i + len] -
70                hash2[i] * pow2[len] % MOD2 +
71                MOD2
72            ) % MOD2;
73
74            // Combine both hashes into one key.
75            long key = h1 * MOD2 + h2;
76
77            int count = map.getOrDefault(key, 0) + 1;
78
79            map.put(key, count);
80        }
81
82        for (int count : map.values()) {
83            if (count == 1) {
84                return true;
85            }
86        }
87
88        return false;
89    }
90}
91