1class Solution {
2
3    static class Node {
4        int product;
5        int[] count;
6
7        Node(int k) {
8            count = new int[k];
9        }
10    }
11
12    int n;
13    int k;
14    Node[] tree;
15
16    public int[] resultArray(int[] nums, int k, int[][] queries) {
17        this.n = nums.length;
18        this.k = k;
19
20        tree = new Node[4 * n];
21
22        build(1, 0, n - 1, nums);
23
24        int[] answer = new int[queries.length];
25
26        for (int i = 0; i < queries.length; i++) {
27
28            int index = queries[i][0];
29            int value = queries[i][1];
30            int start = queries[i][2];
31            int x = queries[i][3];
32
33            // Permanent update
34            update(1, 0, n - 1, index, value);
35
36            // Query [start, n - 1]
37            Node result = query(1, 0, n - 1, start, n - 1);
38
39            answer[i] = result.count[x];
40        }
41
42        return answer;
43    }
44
45    // Build segment tree
46    private void build(int node, int left, int right, int[] nums) {
47
48        if (left == right) {
49            tree[node] = new Node(k);
50
51            int remainder = nums[left] % k;
52
53            tree[node].product = remainder;
54            tree[node].count[remainder] = 1;
55
56            return;
57        }
58
59        int mid = left + (right - left) / 2;
60
61        build(node * 2, left, mid, nums);
62        build(node * 2 + 1, mid + 1, right, nums);
63
64        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
65    }
66
67    // Update one element
68    private void update(int node, int left, int right,
69                       int index, int value) {
70
71        if (left == right) {
72
73            int remainder = value % k;
74
75            tree[node] = new Node(k);
76
77            tree[node].product = remainder;
78            tree[node].count[remainder] = 1;
79
80            return;
81        }
82
83        int mid = left + (right - left) / 2;
84
85        if (index <= mid) {
86            update(node * 2, left, mid, index, value);
87        } else {
88            update(node * 2 + 1, mid + 1, right, index, value);
89        }
90
91        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
92    }
93
94    // Query range [queryLeft, queryRight]
95    private Node query(int node, int left, int right,
96                       int queryLeft, int queryRight) {
97
98        if (queryLeft <= left && right <= queryRight) {
99            return tree[node];
100        }
101
102        int mid = left + (right - left) / 2;
103
104        if (queryRight <= mid) {
105            return query(node * 2, left, mid,
106                         queryLeft, queryRight);
107        }
108
109        if (queryLeft > mid) {
110            return query(node * 2 + 1, mid + 1, right,
111                         queryLeft, queryRight);
112        }
113
114        Node leftNode = query(node * 2, left, mid,
115                              queryLeft, queryRight);
116
117        Node rightNode = query(node * 2 + 1, mid + 1, right,
118                               queryLeft, queryRight);
119
120        return merge(leftNode, rightNode);
121    }
122
123    // Merge two consecutive segments
124    private Node merge(Node leftNode, Node rightNode) {
125
126        Node result = new Node(k);
127
128        // Product of entire segment
129        result.product =
130            (leftNode.product * rightNode.product) % k;
131
132        // Prefixes completely inside left segment
133        for (int remainder = 0; remainder < k; remainder++) {
134            result.count[remainder] += leftNode.count[remainder];
135        }
136
137        // Prefixes that cross from left into right
138        for (int remainder = 0; remainder < k; remainder++) {
139
140            int newRemainder =
141                (leftNode.product * remainder) % k;
142
143            result.count[newRemainder] +=
144                rightNode.count[remainder];
145        }
146
147        return result;
148    }
149}