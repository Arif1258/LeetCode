1import java.util.*;
2
3class Solution {
4    public int[][] insert(int[][] intervals, int[] newInterval) {
5
6        List<int[]> ans = new ArrayList<>();
7        int i = 0;
8        int n = intervals.length;
9        while (i < n && intervals[i][1] < newInterval[0]) {
10            ans.add(intervals[i]);
11            i++;
12        }
13        while (i < n && intervals[i][0] <= newInterval[1]) {
14            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
15            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
16            i++;
17        }
18        ans.add(newInterval);
19        while (i < n) {
20            ans.add(intervals[i]);
21            i++;
22        }
23
24        return ans.toArray(new int[ans.size()][]);
25    }
26}