1class Solution {
2    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
3        TreeSet<Integer> available = new TreeSet<>();
4        PriorityQueue<int[]> busy = new PriorityQueue<>(
5            (a, b) -> Integer.compare(a[0], b[0])
6        );
7        int[] count = new int[k];
8        int maxRequests = 0;
9        for (int i = 0; i < k; i++) {
10            available.add(i);
11        }
12        for (int i = 0; i < arrival.length; i++) {
13            int time = arrival[i];
14            while (!busy.isEmpty() && busy.peek()[0] <= time) {
15                int[] server = busy.poll();
16                available.add(server[1]);
17            }
18            if (available.isEmpty()) {
19                continue;
20            }
21            int preferred = i % k;
22            Integer server = available.ceiling(preferred);
23            if (server == null) {
24                server = available.first();
25            }
26
27            available.remove(server);
28
29            count[server]++;
30            maxRequests = Math.max(maxRequests, count[server]);
31
32            busy.offer(new int[]{
33                time + load[i],
34                server
35            });
36        }
37        List<Integer> result = new ArrayList<>();
38        for (int i = 0; i < k; i++) {
39            if (count[i] == maxRequests) {
40                result.add(i);
41            }
42        }
43        return result;
44    }
45}
46