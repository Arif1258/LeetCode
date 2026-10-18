1class Solution {
2    public int[][] merge(int[][] intervals) {
3        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
4
5        List<int[]> list = new ArrayList<>();
6
7        for (int[] interval : intervals) {
8            if (list.isEmpty() || list.get(list.size() - 1)[1] < interval[0]) {
9                list.add(interval);
10            } else {
11                list.get(list.size() - 1)[1] =
12                    Math.max(list.get(list.size() - 1)[1], interval[1]);
13            }
14        }
15
16        return list.toArray(new int[list.size()][]);
17    }
18}