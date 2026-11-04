1import java.util.*;
2
3class Solution {
4
5    private TreeMap<Integer, Integer> lower = new TreeMap<>();
6    private TreeMap<Integer, Integer> upper = new TreeMap<>();
7
8    private int lowerSize = 0;
9    private int upperSize = 0;
10
11    private long lowerSum = 0;
12    private long upperSum = 0;
13
14    public long minOperations(int[] nums, int x, int k) {
15        int n = nums.length;
16
17        long[] cost = new long[n - x + 1];
18
19        // Step 1: Calculate the cost of every window of size x.
20        for (int i = 0; i < n; i++) {
21
22            add(nums[i]);
23
24            if (i >= x) {
25                remove(nums[i - x]);
26            }
27
28            if (i >= x - 1) {
29                int start = i - x + 1;
30                cost[start] = getCost();
31            }
32        }
33
34        // Step 2: Dynamic programming.
35        long INF = Long.MAX_VALUE / 4;
36
37        long[] prev = new long[n + 1];
38        long[] curr = new long[n + 1];
39
40        // prev[i] = minimum cost using 0 subarrays.
41        Arrays.fill(prev, 0);
42
43        for (int t = 1; t <= k; t++) {
44
45            Arrays.fill(curr, INF);
46
47            for (int i = 1; i <= n; i++) {
48
49                // Option 1: Skip the current element.
50                curr[i] = curr[i - 1];
51
52                // Option 2: Select a window ending at i - 1.
53                if (i >= x) {
54                    int start = i - x;
55
56                    if (prev[start] != INF) {
57                        curr[i] = Math.min(
58                            curr[i],
59                            prev[start] + cost[start]
60                        );
61                    }
62                }
63            }
64
65            long[] temp = prev;
66            prev = curr;
67            curr = temp;
68        }
69
70        return prev[n];
71    }
72
73    private void add(int value) {
74
75        if (lower.isEmpty() || value <= lower.lastKey()) {
76            insert(lower, value);
77            lowerSize++;
78            lowerSum += value;
79        } else {
80            insert(upper, value);
81            upperSize++;
82            upperSum += value;
83        }
84
85        rebalance();
86    }
87
88    private void remove(int value) {
89
90        if (lower.containsKey(value)) {
91            erase(lower, value);
92            lowerSize--;
93            lowerSum -= value;
94        } else {
95            erase(upper, value);
96            upperSize--;
97            upperSum -= value;
98        }
99
100        rebalance();
101    }
102
103    private void rebalance() {
104
105        // lower must contain either the same number
106        // of elements as upper or one extra element.
107
108        while (lowerSize > upperSize + 1) {
109
110            int value = lower.lastKey();
111
112            erase(lower, value);
113            lowerSize--;
114            lowerSum -= value;
115
116            insert(upper, value);
117            upperSize++;
118            upperSum += value;
119        }
120
121        while (lowerSize < upperSize) {
122
123            int value = upper.firstKey();
124
125            erase(upper, value);
126            upperSize--;
127            upperSum -= value;
128
129            insert(lower, value);
130            lowerSize++;
131            lowerSum += value;
132        }
133    }
134
135    private long getCost() {
136
137        int median = lower.lastKey();
138
139        long leftCost =
140            (long) median * lowerSize - lowerSum;
141
142        long rightCost =
143            upperSum - (long) median * upperSize;
144
145        return leftCost + rightCost;
146    }
147
148    private void insert(TreeMap<Integer, Integer> map, int value) {
149        map.put(value, map.getOrDefault(value, 0) + 1);
150    }
151
152    private void erase(TreeMap<Integer, Integer> map, int value) {
153
154        int count = map.get(value);
155
156        if (count == 1) {
157            map.remove(value);
158        } else {
159            map.put(value, count - 1);
160        }
161    }
162}