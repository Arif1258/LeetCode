1
2class Solution {
3    int[] ans;
4    List<Integer>[] tree;
5    int[] last;
6
7    public int[] findSubtreeSizes(int[] parent, String s) {
8        int n = parent.length;
9
10        tree = new ArrayList[n];
11        for (int i = 0; i < n; i++) {
12            tree[i] = new ArrayList<>();
13        }
14
15        // Build original tree
16        for (int i = 1; i < n; i++) {
17            tree[parent[i]].add(i);
18        }
19
20        ans = new int[n];
21        last = new int[26];
22        Arrays.fill(last, -1);
23
24        // Construct modified tree
25        List<Integer>[] modified = new ArrayList[n];
26        for (int i = 0; i < n; i++) {
27            modified[i] = new ArrayList<>();
28        }
29
30        build(0, s, modified);
31
32        // Calculate subtree sizes
33        dfs(0, modified);
34
35        return ans;
36    }
37
38    void build(int node, String s, List<Integer>[] modified) {
39        int c = s.charAt(node) - 'a';
40
41        int old = last[c];
42        last[c] = node;
43
44        for (int child : tree[node]) {
45            int ch = s.charAt(child) - 'a';
46
47            int newParent = last[ch] == -1
48                    ? node
49                    : last[ch];
50
51            modified[newParent].add(child);
52
53            build(child, s, modified);
54        }
55
56        last[c] = old;
57    }
58
59    int dfs(int node, List<Integer>[] modified) {
60        int size = 1;
61
62        for (int child : modified[node]) {
63            size += dfs(child, modified);
64        }
65
66        return ans[node] = size;
67    }
68}
69