1import java.util.*;
2
3class Solution {
4    static class State {
5        long score;
6        int[] indices;
7
8        State(long score, int[] indices) {
9            this.score = score;
10            this.indices = indices;
11        }
12    }
13
14    public int[] maximumWeight(List<List<Integer>> intervals) {
15        int n = intervals.size();
16        int[][] a = new int[n][4];
17
18        for (int i = 0; i < n; i++) {
19            a[i][0] = intervals.get(i).get(0);
20            a[i][1] = intervals.get(i).get(1);
21            a[i][2] = intervals.get(i).get(2);
22            a[i][3] = i;
23        }
24
25        Arrays.sort(a, (x, y) -> {
26            if (x[0] != y[0]) return Integer.compare(x[0], y[0]);
27            if (x[1] != y[1]) return Integer.compare(x[1], y[1]);
28            return Integer.compare(x[3], y[3]);
29        });
30
31        int[] start = new int[n];
32
33        for (int i = 0; i < n; i++) {
34            start[i] = a[i][0];
35        }
36
37        int[] next = new int[n];
38
39        for (int i = 0; i < n; i++) {
40            next[i] = upperBound(start, a[i][1]);
41        }
42
43        State[][] dp = new State[n + 1][5];
44
45        for (int i = 0; i <= n; i++) {
46            for (int k = 0; k <= 4; k++) {
47                dp[i][k] = new State(0, new int[0]);
48            }
49        }
50
51        for (int i = n - 1; i >= 0; i--) {
52            for (int k = 1; k <= 4; k++) {
53                State skip = dp[i + 1][k];
54                State nxt = dp[next[i]][k - 1];
55
56                int[] takeIndices = new int[nxt.indices.length + 1];
57
58                System.arraycopy(
59                    nxt.indices,
60                    0,
61                    takeIndices,
62                    0,
63                    nxt.indices.length
64                );
65
66                takeIndices[nxt.indices.length] = a[i][3];
67
68                Arrays.sort(takeIndices);
69
70                State take = new State(
71                    a[i][2] + nxt.score,
72                    takeIndices
73                );
74
75                if (take.score > skip.score) {
76                    dp[i][k] = take;
77                } else if (take.score < skip.score) {
78                    dp[i][k] = skip;
79                } else {
80                    dp[i][k] = compare(take.indices, skip.indices) < 0
81                        ? take
82                        : skip;
83                }
84            }
85        }
86
87        return dp[0][4].indices;
88    }
89
90    private int upperBound(int[] arr, int target) {
91        int left = 0;
92        int right = arr.length;
93
94        while (left < right) {
95            int mid = left + (right - left) / 2;
96
97            if (arr[mid] <= target) {
98                left = mid + 1;
99            } else {
100                right = mid;
101            }
102        }
103
104        return left;
105    }
106
107    private int compare(int[] a, int[] b) {
108        int n = Math.min(a.length, b.length);
109
110        for (int i = 0; i < n; i++) {
111            if (a[i] != b[i]) {
112                return Integer.compare(a[i], b[i]);
113            }
114        }
115
116        return Integer.compare(a.length, b.length);
117    }
118}