1import java.util.Arrays;
2
3class Solution {
4    public int eraseOverlapIntervals(int[][] intervals) {
5        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
6
7        int count = 0;
8        int lastEnd = intervals[0][1];
9
10        for (int i = 1; i < intervals.length; i++) {
11            if (intervals[i][0] < lastEnd) {
12                count++;
13            } else {
14                lastEnd = intervals[i][1];
15            }
16        }
17
18        return count;
19    }
20}