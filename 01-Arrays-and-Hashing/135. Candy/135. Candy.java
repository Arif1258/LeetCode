1class Solution {
2    public int candy(int[] ratings) {
3        int n = ratings.length;
4        int[] candies = new int[n];
5        for (int i = 0; i < n; i++) {
6            candies[i] = 1;
7        }
8        for (int i = 1; i < n; i++) {
9            if (ratings[i] > ratings[i - 1]) {
10                candies[i] = candies[i - 1] + 1;
11            }
12        }
13        for (int i = n - 2; i >= 0; i--) {
14            if (ratings[i] > ratings[i + 1]) {
15                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
16            }
17        }
18        int total = 0;
19        for (int candy : candies) {
20            total += candy;
21        }
22        return total;
23    }
24}
25