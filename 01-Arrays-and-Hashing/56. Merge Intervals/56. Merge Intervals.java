1class Solution {
2    public int[][] merge(int[][] intervals) {
3        if (intervals.length <= 1) {
4            return intervals;
5        }
6        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
7
8        List<int[]> result = new ArrayList<>();
9
10        int[] newInterval = intervals[0];
11        result.add(newInterval);
12
13        for (int[] interval : intervals) {
14            if (interval[0] <= newInterval[1]) {
15                newInterval[1] = Math.max(newInterval[1], interval[1]);
16            } else {
17                newInterval = interval;
18                result.add(newInterval);
19            }
20        }
21
22        return result.toArray(new int[result.size()][]);
23    }
24}
25