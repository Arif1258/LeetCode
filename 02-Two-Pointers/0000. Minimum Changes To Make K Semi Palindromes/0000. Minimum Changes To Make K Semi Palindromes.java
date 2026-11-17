1
2import java.util.Arrays;
3
4class Solution {
5    public int minimumChanges(String s, int k) {
6        int n = s.length();
7        int INF = 1_000_000_000;
8
9        int[][] cost = new int[n][n];
10
11        for (int[] row : cost) {
12            Arrays.fill(row, INF);
13        }
14
15        // Precompute minimum changes for every substring
16        for (int len = 2; len <= n; len++) {
17            for (int d = 1; d < len; d++) {
18                if (len % d != 0) continue;
19
20                for (int l = 0; l + len <= n; l++) {
21                    int r = l + len - 1;
22                    int changes = 0;
23
24                    for (int offset = 0; offset < d; offset++) {
25                        int left = l + offset;
26                        int right = l + offset
27                                + ((len - 1 - offset) / d) * d;
28
29                        while (left < right) {
30                            if (s.charAt(left) != s.charAt(right)) {
31                                changes++;
32                            }
33
34                            left += d;
35                            right -= d;
36                        }
37                    }
38
39                    cost[l][r] = Math.min(cost[l][r], changes);
40                }
41            }
42        }
43
44        // DP: dp[i][j] = minimum changes for first i characters
45        // divided into j semi-palindromes
46        int[][] dp = new int[n + 1][k + 1];
47
48        for (int[] row : dp) {
49            Arrays.fill(row, INF);
50        }
51
52        dp[0][0] = 0;
53
54        for (int parts = 1; parts <= k; parts++) {
55            for (int i = 2 * parts; i <= n; i++) {
56                for (int j = 2 * (parts - 1); j <= i - 2; j++) {
57                    dp[i][parts] = Math.min(
58                        dp[i][parts],
59                        dp[j][parts - 1] + cost[j][i - 1]
60                    );
61                }
62            }
63        }
64
65        return dp[n][k];
66    }
67}
68