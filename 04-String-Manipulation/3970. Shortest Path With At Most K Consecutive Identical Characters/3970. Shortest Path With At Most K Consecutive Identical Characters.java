1
2import java.util.*;
3
4class Solution {
5
6    public int shortestPath(int n, int[][] edges, String labels, int k) {
7
8        List<int[]>[] graph = new ArrayList[n];
9
10        for (int i = 0; i < n; i++) {
11            graph[i] = new ArrayList<>();
12        }
13
14        for (int[] e : edges) {
15            graph[e[0]].add(new int[]{e[1], e[2]});
16        }
17
18        long[][] dist = new long[n][k + 1];
19
20        for (long[] d : dist) {
21            Arrays.fill(d, Long.MAX_VALUE);
22        }
23
24        PriorityQueue<long[]> pq = new PriorityQueue<>(
25            Comparator.comparingLong(a -> a[0])
26        );
27
28        dist[0][1] = 0;
29        pq.offer(new long[]{0, 0, 1});
30
31        while (!pq.isEmpty()) {
32
33            long[] curr = pq.poll();
34
35            long cost = curr[0];
36            int node = (int) curr[1];
37            int count = (int) curr[2];
38
39            if (cost != dist[node][count]) {
40                continue;
41            }
42
43            if (node == n - 1) {
44                return (int) cost;
45            }
46
47            for (int[] edge : graph[node]) {
48
49                int next = edge[0];
50                int weight = edge[1];
51
52                int newCount = (labels.charAt(node) == labels.charAt(next))
53                        ? count + 1 : 1;
54
55                if (newCount > k) {
56                    continue;
57                }
58
59                long newCost = cost + weight;
60
61                if (newCost < dist[next][newCount]) {
62                    dist[next][newCount] = newCost;
63
64                    pq.offer(new long[]{
65                        newCost, next, newCount
66                    });
67                }
68            }
69        }
70
71        return -1;
72    }
73}
74