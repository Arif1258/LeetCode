1class Solution {
2    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
3        Arrays.sort(logs, (a, b) -> a[1] - b[1]);
4        int m = queries.length;
5        int[][] sortedQueries = new int[m][2];
6
7        for (int i = 0; i < m; i++) {
8            sortedQueries[i][0] = queries[i];
9            sortedQueries[i][1] = i;
10        }
11        Arrays.sort(sortedQueries, (a, b) -> a[0] - b[0]);
12        int[] ans = new int[m];
13        int[] freq = new int[n + 1];
14
15        int left = 0;
16        int right = 0;
17        int activeServers = 0;
18        for (int[] q : sortedQueries) {
19            int time = q[0];
20            while (right < logs.length && logs[right][1] <= time) {
21                int server = logs[right][0];
22
23                if (freq[server] == 0) {
24                    activeServers++;
25                }
26
27                freq[server]++;
28                right++;
29            }
30            while (left < right && logs[left][1] < time - x) {
31                int server = logs[left][0];
32                freq[server]--;
33                if (freq[server] == 0) {
34                    activeServers--;
35                }
36                left++;
37            }
38
39            ans[q[1]] = n - activeServers;
40        }
41        return ans;
42    }
43}