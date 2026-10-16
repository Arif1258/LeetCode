1class Solution {
2    private static final int MOD = 1_000_000_007;
3
4    public int sumCounts(int[] nums) {
5        int n = nums.length;
6        SegTree seg = new SegTree(n);
7        int[] last = new int[100001];
8
9        int ans = 0;
10
11        for (int i = 0; i < n; i++) {
12            int x = nums[i];
13            int prev = last[x];
14            seg.update(prev, i, 1);
15            ans = (int) ((ans + seg.query(0, i)) % MOD);
16            last[x] = i + 1;
17        }
18        return ans;
19    }
20
21    private static class SegTree {
22        int n;
23        long[] sum;
24        long[] sumSq;
25        long[] lazy;
26
27        SegTree(int n) {
28            this.n = n;
29            sum = new long[4 * n];
30            sumSq = new long[4 * n];
31            lazy = new long[4 * n];
32        }
33
34        void update(int l, int r, long val) {
35            update(1, 0, n - 1, l, r, val);
36        }
37
38        long query(int l, int r) {
39            return query(1, 0, n - 1, l, r);
40        }
41
42        private void apply(int node, long val, int len) {
43            long oldSum = sum[node];
44
45            sumSq[node] = (
46                sumSq[node]
47                + 2L * val % MOD * oldSum % MOD
48                + (val * val % MOD) * len % MOD
49            ) % MOD;
50
51            sum[node] = (oldSum + val * len) % MOD;
52            lazy[node] = (lazy[node] + val) % MOD;
53        }
54
55        private void push(int node, int left, int right) {
56            if (lazy[node] == 0 || left == right) {
57                return;
58            }
59
60            int mid = left + (right - left) / 2;
61            long val = lazy[node];
62
63            apply(node * 2, val, mid - left + 1);
64            apply(node * 2 + 1, val, right - mid);
65
66            lazy[node] = 0;
67        }
68
69        private void pull(int node) {
70            sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
71            sumSq[node] = (sumSq[node * 2] + sumSq[node * 2 + 1]) % MOD;
72        }
73
74        private void update(
75            int node, int left, int right,
76            int ql, int qr, long val
77        ) {
78            if (ql <= left && right <= qr) {
79                apply(node, val, right - left + 1);
80                return;
81            }
82
83            push(node, left, right);
84
85            int mid = left + (right - left) / 2;
86
87            if (ql <= mid) {
88                update(node * 2, left, mid, ql, qr, val);
89            }
90
91            if (qr > mid) {
92                update(node * 2 + 1, mid + 1, right, ql, qr, val);
93            }
94
95            pull(node);
96        }
97
98        private long query(
99            int node, int left, int right,
100            int ql, int qr
101        ) {
102            if (ql <= left && right <= qr) {
103                return sumSq[node];
104            }
105
106            push(node, left, right);
107
108            int mid = left + (right - left) / 2;
109            long result = 0;
110
111            if (ql <= mid) {
112                result += query(node * 2, left, mid, ql, qr);
113            }
114
115            if (qr > mid) {
116                result += query(node * 2 + 1, mid + 1, right, ql, qr);
117            }
118
119            return result % MOD;
120        }
121    }
122}