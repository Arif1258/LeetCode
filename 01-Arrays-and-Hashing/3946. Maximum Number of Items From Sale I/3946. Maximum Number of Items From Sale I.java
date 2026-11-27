1class Solution {
2    public int maximumSaleItems(int[][] items, int budget) {
3        int n = items.length;
4        int minPrice = Integer.MAX_VALUE;
5        int[] dp = new int[budget + 1];
6
7        for (int i = 0; i < n; i++) {
8            int factor = items[i][0];
9            int price = items[i][1];
10
11            minPrice = Math.min(minPrice, price);
12
13            int count = 1;
14
15            for (int j = 0; j < n; j++) {
16                if (i != j && items[j][0] % factor == 0) {
17                    count++;
18                }
19            }
20
21            for (int b = budget; b >= price; b--) {
22                dp[b] = Math.max(dp[b], dp[b - price] + count);
23            }
24        }
25
26        int ans = 0;
27
28        for (int b = 0; b <= budget; b++) {
29            ans = Math.max(ans, dp[b] + (budget - b) / minPrice);
30        }
31
32        return ans;
33    }
34}