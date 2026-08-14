1class Solution {
2    public int findLongestChain(int[][] pairs) {
3        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
4        int count = 0;
5        int end = Integer.MIN_VALUE;
6
7        for (int[] pair : pairs) {
8            if (pair[0] > end) {
9                count++;
10                end = pair[1];
11            }
12        }
13        return count;
14    }
15}