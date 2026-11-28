1import java.util.Arrays;
2
3class Solution {
4    public int maximumSaleItems(int[][] items, int budget) {
5        int n = items.length;
6        int minPrice = Integer.MAX_VALUE;
7
8        int[] freq = new int[n + 1];
9        int[] gain = new int[n + 1];
10
11        for (int[] item : items) {
12            freq[item[0]]++;
13            minPrice = Math.min(minPrice, item[1]);
14        }
15
16        // Count eligible free items for each factor
17        for (int f = 1; f <= n; f++) {
18            if (freq[f] == 0) continue;
19
20            for (int j = f; j <= n; j += f) {
21                gain[f] += freq[j];
22            }
23
24            gain[f]--;
25        }
26
27        // Sort items by price
28        Arrays.sort(items, (a, b) -> Integer.compare(a[1], b[1]));
29
30        int ans = 0;
31
32        // Purchase profitable items with free copies
33        for (int[] item : items) {
34            int factor = item[0];
35            int price = item[1];
36
37            if (price >= 2L * minPrice || price > budget) {
38                break;
39            }
40
41            int count = Math.min(gain[factor], budget / price);
42
43            ans += 2 * count;
44            budget -= count * price;
45        }
46
47        // Spend remaining budget on the cheapest item
48        return ans + budget / minPrice;
49    }
50}