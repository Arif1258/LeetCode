1class Solution {
2    public int[] assignTasks(int[] servers, int[] tasks) {
3
4        int n = servers.length;
5        int m = tasks.length;
6
7        int[] ans = new int[m];
8
9        PriorityQueue<int[]> available = new PriorityQueue<>(
10            (a, b) -> a[0] != b[0]
11                ? a[0] - b[0]
12                : a[1] - b[1]
13        );
14
15        PriorityQueue<long[]> busy = new PriorityQueue<>(
16            (a, b) -> {
17                if (a[0] != b[0])
18                    return Long.compare(a[0], b[0]);
19                if (a[1] != b[1])
20                    return Long.compare(a[1], b[1]);
21                return Long.compare(a[2], b[2]);
22            }
23        );
24
25        for (int i = 0; i < n; i++) {
26            available.offer(new int[]{servers[i], i});
27        }
28
29        long time = 0;
30
31        for (int i = 0; i < m; i++) {
32
33            time = Math.max(time, i);
34
35            // Release servers that have finished
36            while (!busy.isEmpty() && busy.peek()[0] <= time) {
37                long[] s = busy.poll();
38                available.offer(new int[]{(int) s[1], (int) s[2]});
39            }
40
41            // Wait if no server is available
42            if (available.isEmpty()) {
43                time = busy.peek()[0];
44
45                while (!busy.isEmpty() && busy.peek()[0] <= time) {
46                    long[] s = busy.poll();
47                    available.offer(new int[]{(int) s[1], (int) s[2]});
48                }
49            }
50
51            int[] server = available.poll();
52
53            ans[i] = server[1];
54
55            busy.offer(new long[]{
56                time + tasks[i],
57                server[0],
58                server[1]
59            });
60        }
61
62        return ans;
63    }
64}