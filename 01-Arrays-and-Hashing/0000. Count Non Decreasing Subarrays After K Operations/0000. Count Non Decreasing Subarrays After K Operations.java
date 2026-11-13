1class Solution {
2    public long countNonDecreasingSubarrays(int[] nums, long k) {
3        int n = nums.length;
4        int LOG = 1;
5
6        while ((1 << LOG) <= n) {
7            LOG++;
8        }
9
10        long[] prefix = new long[n + 1];
11
12        for (int i = 0; i < n; i++) {
13            prefix[i + 1] = prefix[i] + nums[i];
14        }
15
16        // Find next greater element
17        int[] next = new int[n];
18        int[] stack = new int[n];
19        int top = -1;
20
21        for (int i = n - 1; i >= 0; i--) {
22            while (top >= 0 && nums[stack[top]] <= nums[i]) {
23                top--;
24            }
25
26            next[i] = (top == -1) ? n : stack[top];
27            stack[++top] = i;
28        }
29
30        // Binary lifting tables
31        int[][] jump = new int[LOG][n];
32        long[][] cost = new long[LOG][n];
33
34        for (int i = 0; i < n; i++) {
35            jump[0][i] = next[i];
36
37            int end = next[i];
38
39            cost[0][i] =
40                (long) nums[i] * (end - i)
41                - (prefix[end] - prefix[i]);
42        }
43
44        for (int p = 1; p < LOG; p++) {
45            for (int i = 0; i < n; i++) {
46                int mid = jump[p - 1][i];
47
48                if (mid < n) {
49                    jump[p][i] = jump[p - 1][mid];
50
51                    cost[p][i] =
52                        cost[p - 1][i] + cost[p - 1][mid];
53                } else {
54                    jump[p][i] = n;
55                    cost[p][i] = cost[p - 1][i];
56                }
57            }
58        }
59
60        // Calculate operations needed for [l, r]
61        long answer = 0;
62        int left = 0;
63
64        for (int right = 0; right < n; right++) {
65
66            while (left <= right &&
67                   getCost(left, right, nums, prefix,
68                           jump, cost, LOG) > k) {
69                left++;
70            }
71
72            answer += right - left + 1;
73        }
74
75        return answer;
76    }
77
78    private long getCost(
79        int left,
80        int right,
81        int[] nums,
82        long[] prefix,
83        int[][] jump,
84        long[][] cost,
85        int LOG
86    ) {
87        long result = 0;
88        int curr = left;
89
90        for (int p = LOG - 1; p >= 0; p--) {
91            int nxt = jump[p][curr];
92
93            if (nxt <= right) {
94                result += cost[p][curr];
95                curr = nxt;
96            }
97        }
98
99        // Remaining final block
100        result += (long) nums[curr] * (right - curr + 1)
101                  - (prefix[right + 1] - prefix[curr]);
102
103        return result;
104    }
105}