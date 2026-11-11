1class Solution {
2    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
3        long option1 = (long) cost1 * need1 + (long) cost2 * need2;
4        long option2 = (long) costBoth * Math.max(need1, need2);
5        long common = Math.min(need1, need2);
6
7        long option3 = (long) common * costBoth
8                     + (long) (need1 - common) * cost1
9                     + (long) (need2 - common) * cost2;
10
11        return Math.min(option1, Math.min(option2, option3));
12    }
13}