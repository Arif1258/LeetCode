1class Solution {
2    public int findMinArrowShots(int[][] points) {
3        int n = points.length;
4        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));
5
6        int arrows = 1;
7        int arrowPos = points[0][1];
8
9        for(int i=1;i<n;i++){
10            if(points[i][0] > arrowPos){
11                arrows++;
12                arrowPos = points[i][1];
13            }
14        }
15        return arrows;
16    }
17}