1class Solution {
2    public boolean stoneGameIX(int[] stones) {
3        int[] cnt = new int[3];
4
5        for (int stone : stones) {
6            cnt[stone % 3]++;
7        }
8        if (cnt[0] % 2 == 0) {
9            return cnt[1] > 0 && cnt[2] > 0;
10        }
11        
12        return Math.abs(cnt[1] - cnt[2]) > 2;
13    }
14}